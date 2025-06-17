# RPGemJava
Este projeto é um jogo de RPG 2D feito em Java. O jogador controla um personagem que foge de inimigos e sobrevive pelo maior tempo possível. O jogo possui um sistema de sprites, gerenciamento de mundo via arquivos CSV, e uma interface gráfica.

## 🎮 Descrição do Jogo
- Você controla um **personagem** que se move por um **mundo 2D tile-based**.
- Há **inimigos (zumbis)** que atacam o jogador.
- O mundo e os dados de jogo são armazenados em arquivos `.csv`.

## 🧱 Estrutura do Projeto
```
├── Documentos.iml
├── README.md
├── assets
    └── sprites
    │   ├── bush
    │       ├── bush0.png
    │       └── bush1.png
    │   ├── floor
    │       ├── grass.png
    │       └── water.png
    │   ├── player
    │       ├── player_walk0.png
    │       └── player_walk1.png
    │   ├── rock
    │       ├── rock0.png
    │       └── rock1.png
    │   ├── tree
    │       ├── tree0.png
    │       ├── tree1.png
    │       └── tree2.png
    │   └── zombie
    │       └── zumbi.png
├── data
    ├── save.csv
    └── world.csv
├── out
    └── production
    │   └── com
    │       └── rpg
    │           ├── Animation.class
    │           ├── AssetLoader.class
    │           ├── CSVUtil.class
    │           ├── Character.class
    │           ├── GameException.class
    │           ├── GameObject.class
    │           ├── GameOverException.class
    │           ├── GamePanel.class
    │           ├── Main.class
    │           ├── Player.class
    │           ├── Resource.class
    │           ├── ResourceType.class
    │           ├── SpriteSheet.class
    │           ├── Sword.class
    │           ├── World$1.class
    │           ├── World.class
    │           └── Zombie.class
└── src
    └── com
        └── rpg
            ├── Animation.java
            ├── AssetLoader.java
            ├── CSVUtil.java
            ├── Character.java
            ├── GameObject.java
            ├── GameOverException.java
            ├── GamePanel.java
            ├── Main.java
            ├── Player.java
            ├── Resource.java
            ├── ResourceType.java
            ├── World.java
            └── Zombie.java
```
## 🛠️ Tecnologias Utilizadas
- Java
- Interface gráfica baseada em **Swing**
- Organização modular por pacotes
- Sprites PNG para renderização 2D
- Arquivos CSV para mapear e salvar o mundo

## 🚀 Como Executar
1. Clone o repositório:
   ```bash
   git clone https://github.com/SEU_USUARIO/RPG.git
   cd RPG
   ```
2. Compile o projeto:
   javac -d out src/com/rpg/*.java
3. Execute o jogo:
   java -cp out com.rpg.Main
   
## 👤 Autores
- Maria Eduarda Zampieron (@ashulyz) e Felipe Fernandes Bortolino (@maidenzinho)
