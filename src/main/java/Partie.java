import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.move.Move;

public class Partie {
    Board echequier;
    JoueurIA joueurNoir;
    JoueurIA joueurBlanc;
    Generation generation;

    public Partie(JoueurIA joueurNoir, JoueurIA joueurBlanc) {
        this.joueurNoir = joueurNoir;
        this.joueurBlanc = joueurBlanc;
        this.generation = generation;
        echequier = new Board();
    }

    public void getPNGPartie() {
        String PNG = "   [Event \"Live Chess\"]\n" +
                "        [Site \"https://github.com/FlorentVASSEURBERLIOUX\"]\n" +
                "        [Date \"0001.01.01\"]\n" +
                "        [Round \"?\"]\n" +
                "        [White \" N°" + generation.getClassementJoueurs().indexOf(joueurBlanc) + 1 + "\"]\n" +
                "        [Black \" N°" + generation.getClassementJoueurs().indexOf(joueurNoir) + 1 + "\"]\n" +
                "        [Result \"1/2-1/2\"]\n" +
                "        [TimeControl \"600\"]\n" +
                "        [WhiteElo \"" + joueurBlanc.getRecompense() + " pts\"]\n" +
                "        [BlackElo \"" + joueurNoir.getRecompense() + " pts\"]\n" +
                "        [Termination \"Suspense\"]\n" +
                "        [ECO \"B10\"]\n" +
                "        [EndTime \"00:00:00 PST\"]\n" +
                "        [Link \"https://github.com/FlorentVASSEURBERLIOUX\"]\n" +
                "\n";
    }

    public int getClassementJoueur(JoueurIA joueur) {
        return generation.getClassementJoueurs().indexOf(joueur) + 1;
    }
}