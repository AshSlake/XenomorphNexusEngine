package xenomorfo;

import localizacoes.Localizacoes;
import principal.Localizacao;

public class Xenomorfo {

    private int id; // identificação do xenomorfo
    private String nome; // nome do xeno, tenho certeza que eles tem um kk
    private String tipo; // Ex: "Drone", "Warrior", "Queen", etc.
    private int saude; // PV do xenomorfo
    private int forca;
    private int velocidade;
    private int inteligencia; // Inteligencia do xeno, eles aprendem bem rapido cuidado
    private String estado; // Ex: "Vivo", "Morto", "Procurando Presa", "Atacando".
    private Localizacao localizacao;
    private Localizacao ninho;
    private Visao visao; // visão do xenomorfo
    private Memoria memoria; //memoria do xenomorfo
    private int numeroDePresas;
    private boolean temNinho; // se o xenomorfo tem um ninho ou não

    // construtor do Xenomorfo

    public Xenomorfo() {}

    public Xenomorfo(int id, String nome, String especie, int saude, int forca, int velocidade, int inteligencia,
            int presas, int xlocal, int ylocal, int alturaMapa, int larguraMapa, boolean ninho) {
        this.id = id;
        this.nome = nome;
        this.tipo = especie;
        this.saude = saude;
        this.forca = forca;
        this.velocidade = velocidade;
        this.inteligencia = inteligencia;
        this.numeroDePresas = presas;
        this.temNinho = false;
        this.localizacao = new Localizacao(xlocal, ylocal); // localização atual do xenomorfo
        this.estado = "Vivo";
        this.visao = new Visao(xlocal, ylocal); // visão baseada na localização atual do xenomorfo
        this.memoria = new Memoria(alturaMapa, larguraMapa); // memoria do xenomorfo
    }

    

    // getters e setters para melhor encapsulamento.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumeroDePresas() {
        return numeroDePresas;
    }

    public void setNumeroDePresas(int numeroDePresas) {
        this.numeroDePresas = numeroDePresas;
    }

    public boolean getTemNinho() {
        return temNinho;
    }

    public void setTemNinho(boolean temNinho) {
        this.temNinho = false;
    }

    public Localizacao getNinho() {
        return ninho;
    }

    public void setNinho(Localizacao ninho) {
        this.ninho = ninho;
    }

    public Localizacao getLocalizacao() { // retona a localização
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) { // Recebe Localizacao
        this.localizacao = localizacao;
    }

    public void setLocalizacao(int xlocal, int ylocal) { // Alternativa para definir x e y diretamente
        this.localizacao.setX(xlocal);
        this.localizacao.setY(ylocal);
    }

    public Visao getVisao() {
        return visao;
    }

    public void setVisao(Visao visao) {
        this.visao = visao;
    }

    public Memoria getMemoria() {
        return memoria;
    }

    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }

    // metodos do Xenomorfo

    public void definirTipo(String tipo) {
        setTipo(tipo);
    }

   //metodo para mover o xenomorfo
    public void mover(int novoX, int novoY, Localizacoes mapa) {
        this.localizacao.setX(novoX);
        this.localizacao.setY(novoY);
        this.visao.setX(novoX);
        this.visao.setY(novoY);
        this.memoria.atualizarMemoria(visao); // Atualiza a memória após o movimento
        this.visao.atualizarVisao(mapa); // atualiza a visão após o movimento 

    }

    public void verVisaoXenomorfo() {
        System.out.println(this.visao);
    }

    public void emitirGrunido() {
        System.out.println("Xenomorfo Emite um grunido");
    }

    public void emitirRugido() {
        System.out.println("Xenomorfo Emite um Rugido");
    }

    public boolean avaliarAlvo(boolean alvo) {

        if (alvo == true) {
            return true;
        } else {
            return false;
        }

    }

    public boolean avaliarAlvoReprodução(boolean alvo) {

        if (alvo == true) {
            return true;
        } else {
            return false;
        }

    }

    public void atacar() {
        System.out.println("Xenomorfo Ataca seu Alvo!!");
    }

    public void criarNinho(Localizacao localizacao) {
        this.temNinho = true;
        this.setNinho(localizacao);
    }

    public void levarParaNinho() {
    }

    public void receberDano(int dano) {
        saude -= dano;
        if (saude <= 0) {
            morrer();
        }
    }

    public void morrer() {
        estado = "morto";
        System.out.println(nome + " Morreu!");
    }

}
