public abstract class Personagem {
    protected String nome;
    protected int pv;
    protected int ataque;
    protected int defesa;
    protected int mana;

    public Personagem(String nome, int pv, int ataque, int defesa, int mana) {
        this.nome = nome;
        this.pv = pv;
        this.ataque = ataque;
        this.defesa = defesa;
        this.mana = mana;
    }

    public boolean estaVivo() {
        return this.pv > 0;
    }

    public void receberDano(int dano) {
        int danoFinal = dano - this.defesa;
        if (danoFinal < 0) {
            danoFinal = 0;
        }
        this.pv -= danoFinal;
        System.out.println(this.nome + " recebeu " + danoFinal + " de dano!");
    }

    public abstract void atacar(Personagem alvo);

    public String getStatus() {
        return nome + " - PV: " + pv + ", Ataque: " + ataque + ", Defesa: " + defesa + ", Mana: " + mana;
    }
}

