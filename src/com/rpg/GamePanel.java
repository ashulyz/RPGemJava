package com.rpg;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 * Painel principal do jogo, responsável por desenhar e atualizar o game loop.
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener {
    public static final int WIDTH = 1024, HEIGHT = 768; // Tamanho da tela
    private Timer timer; // Timer para o game loop (~60 FPS)
    private World world; // Mapa do jogo
    private Player player; // Jogador
    private long startTime; // Tempo de início da partida
    private long elapsed; // Tempo decorrido
    private boolean gameOver = false; // Flag de game over

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT)); // Define o tamanho do painel
        setFocusable(true); // Permite receber eventos de teclado
        addKeyListener(this); // Adiciona o listener de teclado

        this.world = new World("data/world.csv"); // Carrega o mapa
        this.player = new Player(world.getPlayerStartX(), world.getPlayerStartY(), world); // Cria o player

        world.spawnZombies(player); // Spawna zumbis no mapa

        this.timer = new Timer(16, this); // Timer para atualizar o jogo a cada 16ms (~60 FPS)
    }

    /**
     * Inicia o jogo.
     */
    public void startGame() {
        startTime = System.currentTimeMillis(); // Marca o início
        timer.start(); // Inicia o timer
    }

    /**
     * Atualiza o estado do jogo a cada tick do timer.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            player.update();           // Atualiza o jogador
            world.updateZombies();     // Atualiza os zumbis
            elapsed = System.currentTimeMillis() - startTime; // Atualiza o tempo
            if (player.isDead()) {
                gameOver = true;
                timer.stop();
                world.saveBestTime(elapsed); // Salva o tempo sobrevivido
            }
        }
        repaint();  // Solicita uma nova pintura para a tela
    }

    /**
     * Lê o melhor tempo salvo em save.csv.
     */
    private long getBestTime() {
        long best = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("data/save.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    long t = Long.parseLong(line.trim());
                    if (t > best) best = t;
                } catch (NumberFormatException ignored) {}
            }
        } catch (IOException ignored) {}
        return best;
    }

    /**
     * Desenha todos os elementos do jogo.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        world.draw(g);    // Desenha o mapa e os zumbis
        player.draw(g);   // Desenha o player

        // Barra de vida
        g.setColor(Color.RED);
        g.fillRect(20, 20, player.getHealth() * 2, 16);
        g.setColor(Color.BLACK);
        g.drawRect(20, 20, player.getMaxHealth() * 2, 16);

        // Tempo de sobrevivência
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Tempo: " + (elapsed / 1000.0) + "s", 20, 60);

        // Tela de game over
        if (gameOver) {
            g.setFont(new Font("Arial", Font.BOLD, 42));
            g.setColor(Color.RED);
            g.drawString("GAME OVER!", WIDTH / 2 - 120, HEIGHT / 2 - 40);
            g.setFont(new Font("Arial", Font.PLAIN, 28));
            g.setColor(Color.WHITE);
            g.drawString("Sobreviveu por: " + (elapsed / 1000.0) + " segundos", WIDTH / 2 - 160, HEIGHT / 2);

            // Mostra o melhor tempo (ranking)
            long best = getBestTime();
            g.setFont(new Font("Arial", Font.BOLD, 22));
            g.setColor(Color.YELLOW);
            g.drawString("Melhor tempo: " + (best / 1000.0) + " segundos", WIDTH / 2 - 120, HEIGHT / 2 + 40);
        }
    }

    // Eventos de teclado: repassa para o player
    @Override public void keyPressed(KeyEvent e) { player.keyPressed(e); }
    @Override public void keyReleased(KeyEvent e) { player.keyReleased(e); }
    @Override public void keyTyped(KeyEvent e) { }
}