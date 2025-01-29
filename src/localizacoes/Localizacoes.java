package localizacoes;

import java.util.Random;

import xenomorfo.Xenomorfo;

public class Localizacoes {

    private int largura;
    private int altura;
    private int[][] grid;
    private Random random = new Random();


    public Localizacoes(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        this.grid = new int[altura][largura];

        // Inicializa o mapa com valores padrão (vazio)
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                grid[y][x] = 0; // 0 representa um espaço vazio
            }
        }
    }

    // Método para adicionar uma estrutura ao mapa
    public void adicionarEstrutura(int idEstrutura, int x, int y, int larguraEstrutura, int alturaEstrutura) {
        for (int i = y; i < y + alturaEstrutura && i < altura; i++) {
            for (int j = x; j < x + larguraEstrutura && j < largura; j++) {
                grid[i][j] = idEstrutura;
            }
        }
    }

    // Método para adicionar uma entidade viva ao mapa
    public void adicionarEntidade(int idEntidade, int x, int y) {
        if (x >= 0 && x < largura && y >= 0 && y < altura) {
            grid[y][x] = idEntidade;
        }
    }



    // Método para obter o ID de uma localização específica
    public int getLocalizacao(int x, int y) {
        if (x >= 0 && x < largura && y >= 0 && y < altura) {
            return grid[y][x];
        } else {
            return -1; // Retorna -1 se a localização for inválida
        }
    }



    //imprimir o mapa
     public void imprimirMapa() {
        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                System.out.print(grid[y][x] + " ");
            }
            System.out.println();
        }
    }




// Método para gerar estruturas aleatórias
// (apenas um exemplo, você pode personalizá-lo)
    public void gerarEstruturasAleatorias(int numEstruturas) {
        for (int i = 0; i < numEstruturas; i++) {
            int idEstrutura = random.nextInt(10) + 1; // IDs de 1 a 10
            int x = random.nextInt(largura);
            int y = random.nextInt(altura);
            int larguraEstrutura = random.nextInt(5) + 1; // Largura de 1 a 5
            int alturaEstrutura = random.nextInt(5) + 1;  // Altura de 1 a 5
            adicionarEstrutura(idEstrutura, x, y, larguraEstrutura, alturaEstrutura);

        }
    }




    // Método para posicionar entidades aleatórias no mapa.
    public void posicionarEntidadesAleatorias(Xenomorfo[] xenomorfos) {
        for (Xenomorfo xenomorfo : xenomorfos) {
            int x, y;
            do {
                x = random.nextInt(largura);
                y = random.nextInt(altura);
            } while (grid[y][x] != 0); // Encontra uma posição vazia no mapa.

            xenomorfo.setLocalizacao(x, y);
            grid[y][x] = xenomorfo.getId(); // Assume que xenomorfos tem IDs.
        }
    }



    //método para retornar largura do mapa
    public int getLargura() {
        return largura;
    }

       //método para retornar altura do mapa
    public int getAltura() {
        return altura;
    }



}