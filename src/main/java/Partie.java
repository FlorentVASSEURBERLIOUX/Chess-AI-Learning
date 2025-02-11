import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.move.Move;
import com.github.bhlangonijr.chesslib.move.MoveList;

public class Partie {
    private Board echequier;
    private JoueurIA joueurNoir;
    private JoueurIA joueurBlanc;
    private Generation generation;
    private MoveList historique;

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
    String PGN = "[Event \"Live Chess\"]\n" +
                 "[Site \"https://github.com/FlorentVASSEURBERLIOUX\"]\n" +
                 "[Date \"0001.01.01\"]\n" +
                 "[Round \"?\"]\n" +
                 "[White \"Gen" + joueurBlanc.getNGeneration() + " N°" + getClassementJoueur(joueurBlanc) + "\"]\n" +
                 "[Black \"Gen" + joueurNoir.getNGeneration() + " N°" + getClassementJoueur(joueurNoir) + "\"]\n" +
                 "[Result \"1/2-1/2\"]\n" +
                 "[TimeControl \"600\"]\n" +
                 "[WhiteElo \"" + joueurBlanc.getRecompense() + " pts\"]\n" +
                 "[BlackElo \"" + joueurNoir.getRecompense() + " pts\"]\n" +
                 "[Termination \"Suspense\"]\n" +
                 "[ECO \"B10\"]\n" +
                 "[EndTime \"00:00:00 PST\"]\n" +
                 "[Link \"https://github.com/FlorentVASSEURBERLIOUX\"]\n\n";
    
    int coupNum = 1;
    for (int i = 0; i < historique.size(); i++) {
        if (i % 2 == 0) {
            PGN += coupNum + ". ";
            coupNum++;
        }
        PGN += historique.get(i).toString() + " ";
    }
    PGN += "1/2-1/2\n";  
    return PGN;
}

    public int getClassementJoueur(JoueurIA joueur) {
        return generation.getClassementJoueurs().indexOf(joueur) + 1;
    }

    public void sauvegarderPGN() {
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
