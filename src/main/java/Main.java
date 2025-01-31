import com.github.bhlangonijr.chesslib.Board;
import com.github.bhlangonijr.chesslib.move.Move;
//import javax.swing.SwingUtilities; // plus tard

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.toString());

        Move move1 = new Move("e2e4", board.getSideToMove());
        board.doMove(move1);

        System.out.println(board.toString());

        Move move2 = new Move("c7c6", board.getSideToMove());
        board.doMove(move2);

        System.out.println(board.toString());

        System.out.println(board.getFen());
    }
}
