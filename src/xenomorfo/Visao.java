package xenomorfo;

import localizacoes.Localizacoes;

public class Visao {

    private int x;
    private int y;
    private int[][] gridVisao;

    public Visao(int x, int y) {
        this.x = x;
        this.y = y;
        this.gridVisao = new int[6][6];
    }

    public void atualizarVisao(Localizacoes mapa) {
        int centroX = 2; // Definindo um ponto central (ajuste caso necessário)
        int centroY = 2; 

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                int posX = x + (j - centroX); // Ajuste da posição x
                int posY = y + (i - centroY); // Ajuste da posição y

                if (posX >= 0 && posX < mapa.getLargura() && posY >= 0 && posY < mapa.getAltura()) {
                    gridVisao[i][j] = mapa.getLocalizacao(posX, posY);
                } else {
                    gridVisao[i][j] = -2; // Fora do mapa
                }
            }
        }
    }

    public void imprimirVisao() {
        System.out.println("Visão do Xenomorfo:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(String.format("%2d ", gridVisao[i][j]));
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[][] getGridVisao() {
        return gridVisao;
    }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                sb.append(String.format("%2d ", gridVisao[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
