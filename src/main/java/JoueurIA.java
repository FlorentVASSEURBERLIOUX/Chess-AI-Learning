
public class JoueurIA {
    private Cerveau cerveau;
    private int recompense;

    public JoueurIA(int TailleEntrée, int TailleSortie) {
        cerveau = new Cerveau(TailleEntrée, TailleSortie);
        recompense = 0;
    }
}