package jogoDeDados;
import java.util.Random;

public class Dados {
    private int dado1;
    private int dado2;

    public void lancar() {
        final Random random = new Random();
        dado1 = random.nextInt(6) + 1;
        dado2 = random.nextInt(6) + 1;
    }

    public int getDado1() {
        return dado1;
    }

    public int getDado2() {
        return dado2;
    }

    public int getSoma() {
        return dado1 + dado2;
    }
}
