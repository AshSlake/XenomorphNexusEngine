package xenomorfo;

import java.util.Arrays;

public class Memoria {

    private int[][] mapaMental;
    private int[][] entidadesMapaMental;
    private int largura;
    private int altura;

    public Memoria(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        this.mapaMental = new int[altura][largura];
        this.entidadesMapaMental = new int[altura][largura];

        // Inicializa os mapas mentais com -1 (desconhecido)
        for (int[] row : mapaMental) {
            Arrays.fill(row, -1);
        }
        for (int[] row : entidadesMapaMental) {
            Arrays.fill(row, -1);
        }
    }

    public void atualizarMemoria(Visao visao) {
        int xXeno = visao.getX();
        int yXeno = visao.getY();
        int[][] gridVisao = visao.getGridVisao();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                int mapaX = xXeno + j - 2;
                int mapaY = yXeno + i - 2;

                if (mapaX >= 0 && mapaX < largura && mapaY >= 0 && mapaY < altura) {

                    int valorVisao = gridVisao[i][j];

                    if (valorVisao > 0) { // Verifica se é uma entidade.
                        // Entidades
                        entidadesMapaMental[mapaY][mapaX] = valorVisao;
                    }

                    else if (valorVisao < 0 && valorVisao != -2) // Se for uma estrutura
                    {

                        mapaMental[mapaY][mapaX] = valorVisao;

                    }

                    else if (valorVisao == 0) // Se for um espaço vazio
                    {
                        mapaMental[mapaY][mapaX] = valorVisao;

                    }

                }
            }
        }
    }

    // imprimir o mapa mental
    public void imprimirMapaMental() {

        System.out.println("Mapa Mental (Estruturas):");
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                if (mapaMental[y][x] == -1) {
                    System.out.print("? "); // Desconhecido.
                } else {
                    System.out.print(mapaMental[y][x] + " ");
                }

            }
            System.out.println();
        }
        System.out.println("\n Entidades no Mapa Mental:");

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                if (entidadesMapaMental[y][x] == -1) {
                    System.out.print("? "); // Desconhecido
                } else {
                    System.out.print(entidadesMapaMental[y][x] + " ");
                }

            }
            System.out.println();
        }
    }

    public int[][] getMapaMental() {
        return mapaMental;
    }

    public int[][] getEntidadesMapaMental() {
        return entidadesMapaMental;
    }
}