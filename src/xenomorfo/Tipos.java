package xenomorfo;

import java.util.Random;

public enum Tipos {
    
    DRONE("Explorador e operário da colmeia."),
    WARRIOR("Defensor da colmeia e lutador."),
    QUEEN("Líder da colmeia, responsável pela reprodução.");

    private String descricao;

    Tipos(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    // Método para pegar um tipo aleatório
    public static Tipos getTipoAleatorio() {
        Tipos[] valores = Tipos.values();
        return valores[new Random().nextInt(valores.length)];
    }
}


