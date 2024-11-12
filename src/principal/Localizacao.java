package principal;

public class Localizacao {

    private int x;
    private int y;

    public Localizacao(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters e Setters
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


    // Método para calcular a distância entre duas localizações
    public double distancia(Localizacao outraLocalizacao) {
        int deltaX = this.x - outraLocalizacao.getX();
        int deltaY = this.y - outraLocalizacao.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}