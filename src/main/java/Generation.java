import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.move.Move;

import java.util.ArrayList;

public class Generation {
    private ArrayList<JoueurIA> classementJoueurs;
    private int nGeneration;
    private int nJoueur;
    private int nPartieParJoueur;

    public Generation(int nGeneration, int nJoueur, int nPartieParJoueur, ArrayList<JoueurIA> joueurs) {
        this.nGeneration = nGeneration;
        this.nJoueur = nJoueur;
        this.nPartieParJoueur = nPartieParJoueur;
        this.classementJoueurs = joueurs;
    }

    public ArrayList<JoueurIA> getClassementJoueurs() {
        return classementJoueurs;
    }

}
