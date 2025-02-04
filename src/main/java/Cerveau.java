import java.util.Random;

public class Cerveau {
    private double[][] neuronnes;
    private Random random;

    public Cerveau(int TailleEntrée, int TailleSortie) {
        neuronnes = new double[TailleEntrée][TailleSortie];
        for (int i = 0; i < neuronnes.length; i++) {
            for (int j = 0; j < neuronnes[i].length; j++) {
                neuronnes[i][j] = random.nextDouble();
            }
        }
    }
}