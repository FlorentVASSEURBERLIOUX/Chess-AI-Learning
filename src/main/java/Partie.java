import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.move.Move;
import com.github.bhlangonijr.chesslib.move.MoveList;

public class Partie {
    private Board echequier;
    private JoueurIA joueurNoir;
    private JoueurIA joueurBlanc;
    private Generation generation;
    public MoveList historique;

    public Partie(JoueurIA joueurNoir, JoueurIA joueurBlanc, Generation generation) {
        this.joueurNoir = joueurNoir;
        this.joueurBlanc = joueurBlanc;
        this.generation = generation;
        this.echequier = new Board();
        this.historique = new MoveList();
    }

    public void ajouterCoup(Move coup) {
        echequier.doMove(coup);
        historique.add(coup);
    }

    public String getPGNPartie() {
        String historiqueSAN = historique.toSan();

        String PGN = "[Event \"Live Chess\"]\n" +
                "[Site \"https://github.com/FlorentVASSEURBERLIOUX\"]\n" +
                "[Date \"0001.01.01\"]\n" +
                "[Round \"?\"]\n" +
                "[White \"Gen" + generation.getNGeneration() + " N°" + getClassementJoueur(joueurBlanc) + "\"]\n" +
                "[Black \"Gen" + generation.getNGeneration() + " N°" + getClassementJoueur(joueurNoir) + "\"]\n" +
                "[Result \"1/2-1/2\"]\n" +
                "[TimeControl \"600\"]\n" +
                "[WhiteElo \"" + joueurBlanc.getRecompense() + " pts\"]\n" +
                "[BlackElo \"" + joueurNoir.getRecompense() + " pts\"]\n" +
                "[Termination \"Suspense\"]\n" +
                "[ECO \"B10\"]\n" +
                "[EndTime \"00:00:00 PST\"]\n" +
                "[Link \"https://github.com/FlorentVASSEURBERLIOUX\"]\n\n";

        if (echequier.isDraw()) {
            PGN += historiqueSAN + " 1/2-1/2\n";

        } else if (echequier.isMated()) {
            PGN += historiqueSAN + " 1-0\n";

        } else {
            PGN += historiqueSAN + " 0-1\n";

        }
        return PGN;
    }

    public int getClassementJoueur(JoueurIA joueur) {
        return generation.getClassementJoueurs().indexOf(joueur) + 1;
    }

    public Board getEchequier() {
        return echequier;
    }

    public void sauvegarderPGN() {
        File saveDir = new File("../save");
        saveDir.mkdirs();

        File fichier = new File("../save/Gen" + generation.getNGeneration() + ".pgn");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fichier));
            writer.write(getPGNPartie());
            writer.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
