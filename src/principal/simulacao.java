package principal;

import localizacoes.Localizacoes;
import xenomorfo.Xenomorfo;
import xenomorfo.Visao;

import java.util.ArrayList;
import java.util.Random;

public class simulacao {

    private Localizacoes mapa;
    private ArrayList<Xenomorfo> xenomorfos;
    private Random random;

    public simulacao(int largura, int altura) {
        mapa = new Localizacoes(largura, altura);
        xenomorfos = new ArrayList<>();
        random = new Random();
    }

    public void adicionarXenomorfo(Xenomorfo xenomorfo) {
        xenomorfos.add(xenomorfo);
        mapa.adicionarEntidade(xenomorfo.getId(), xenomorfo.getLocalizacao().getX(), xenomorfo.getLocalizacao().getY());
    }

    // Função para mover o xenomorfo aleatoriamente
    public void moverXenomorfo(Xenomorfo xenomorfo) {
        int novaX = xenomorfo.getLocalizacao().getX() + random.nextInt(3) - 1; // Move aleatoriamente para a esquerda, direita ou não se move
        int novaY = xenomorfo.getLocalizacao().getY() + random.nextInt(3) - 1; // Move aleatoriamente para cima, baixo ou não se move

        // Limita os movimentos dentro do mapa
        if (novaX >= 0 && novaX < mapa.getLargura() && novaY >= 0 && novaY < mapa.getAltura()) {
            mapa.adicionarEntidade(xenomorfo.getId(), novaX, novaY);
            xenomorfo.setLocalizacao(novaX, novaY);
        }
    }

    // Função para realizar uma ação baseada na visão do xenomorfo
    public void acaoXenomorfo(Xenomorfo xenomorfo, Visao visao) {
        visao.atualizarVisao(mapa); // Atualiza a visão do xenomorfo

        // Exemplo de lógica de ação baseada na visão
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                int idEntidade = visao.getGridVisao()[i][j];

                if (idEntidade > 0) { // Se encontrar uma entidade (xenomorfo inimigo ou aliado)
                    // Lógica de ataque, interação, etc.
                    System.out.println(xenomorfo.getNome() + " encontrou uma entidade na posição (" + i + ", " + j + ")");
                }
            }
        }
    }

    // Loop principal da simulação
    public void iniciarSimulacao() {
        while (true) { // Loop infinito (simulação contínua)
            for (Xenomorfo xenomorfo : xenomorfos) {
                Visao visao = new Visao(xenomorfo.getLocalizacao().getX(), xenomorfo.getLocalizacao().getY());
                acaoXenomorfo(xenomorfo, visao); // Chama a ação do xenomorfo
                moverXenomorfo(xenomorfo); // Move o xenomorfo
                visao.imprimirVisao(); // Imprime a visão atualizada
            }

            try {
                Thread.sleep(1000); // Aguarda 1 segundo antes de continuar (simulando o tempo de ação)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        simulacao simulacao = new simulacao(10, 10); // Cria um mapa de 10x10
        Xenomorfo xeno1 = new Xenomorfo(1, "Drone1", null, 0, 0, 0, 0, 0, 0, 0, 0, 0, false);
        Xenomorfo xeno2 = new Xenomorfo(2, "Drone2", null, 2, 2, 0, 0, 0, 0, 0, 0, 0, false);

        simulacao.adicionarXenomorfo(xeno1); // Adiciona o primeiro xenomorfo
        simulacao.adicionarXenomorfo(xeno2); // Adiciona o segundo xenomorfo

        simulacao.iniciarSimulacao(); // Inicia a simulação
    }
}
