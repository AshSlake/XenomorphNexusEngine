package xenomorfo;

import localizacoes.Localizacoes;

public class Visao {

    private int x;
    private int y;
    private int[][] gridVisao = new int[5][6]; // Matriz 5x6 para representar a visão

    public Visao(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void atualizarVisao(Localizacoes mapa) {

        // Preenche a matriz gridVisao com informações do mapa
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                int posX = x + j - 2; // Calcula a posição x no mapa
                int posY = y + i - 2; // Calcula a posição y no mapa

                // Verifica se a posição está dentro dos limites do mapa.
                if (posX >= 0 && posX < mapa.getLargura() && posY >= 0 && posY < mapa.getAltura()) {
                    gridVisao[i][j] = mapa.getLocalizacao(posX, posY);
                } else {
                    gridVisao[i][j] = -2; // fora do mapa
                }

            }

        }

    }

    // Getters e Setters (x e y)
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[][] getGridVisao() {
        return gridVisao;
    }

    @Override
    public String toString() {
        // Imprime a visão como uma matriz
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                sb.append(String.format("%2d ", gridVisao[i][j])); // Formatação para alinhamento
            }
            sb.append("\n");
        }
        return sb.toString();

    }
}