public class Heroi extends Personagem {

    public Heroi(String nome, int pv, int ataque, int defesa, int mana) {
        super(nome, pv, ataque, defesa, mana);
    }

    @Override
    public void atacar(Personagem inimigo) {
        System.out.println(this.nome + " ataca " + inimigo.nome + "!");
        inimigo.receberDano(this.ataque);
    }
}
