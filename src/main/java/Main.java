import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.move.Move;

import java.util.ArrayList;

public class Main {
    static ArrayList<JoueurIA> classementJoueurs;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            classementJoueurs.add(new JoueurIA(0, 0));
        }
    }
}
