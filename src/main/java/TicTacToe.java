import java.util.Arrays;

public class TicTacToe {

    private String board = ".".repeat(9);
    private boolean xIsNext = true;
    private boolean gameOver = false;

    private static final int[][] lines = {
            // rows
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            // columns
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            // diagonals
            {0, 4, 8},
            {2, 4, 6},
    };

    public String Turn(String input) {
        if (gameOver)
            return "Game is over";
        if (input == null || input.length() != 2)
            return "Bad input: expecting two character grid location";
        input = input.toUpperCase(); // tolerate mixed case!
        int row = "ABC".indexOf(input.charAt(0));
        if (row < 0 )
            return "Bad input: expecting grid location to start with A, B or C";
        int col = "123".indexOf(input.charAt(1));
        if (col < 0 )
            return "Bad input: expecting grid location to end with 1, 2 or 3";
        int pos = row + col * 3;
        if (board.charAt(pos) != '.')
            return "Bad input: grid location already occupied";
        String player = xIsNext ? "X" : "O";
        board = board.substring(0, pos) + player + board.substring(pos + 1);
        xIsNext = ! xIsNext; // flip flop
        if (playerWin(player)){
            gameOver = true;
            return "Player " + player + " has won";
        }
        if (board.indexOf('.') == -1){
            gameOver = true;
            return "Draw";
        }
        return "Player " + player + " has taken: " + input;
    }

    private boolean playerWin(String player) {
        boolean hasWon = false;
        char p = player.charAt(0);
        for (int[] line: lines) {
            if (
                    (board.charAt(line[0]) == p) &&
                    (board.charAt(line[1]) == p) &&
                    (board.charAt(line[2]) == p)
            ) {
               hasWon = true;
               break;
            }
        }
        return hasWon;
    }

    @Override
    public String toString() {
        return " ABC" +
                "\n1" + board.substring(0, 3) +
                "\n2" + board.substring(3, 6) +
                "\n3" + board.substring(6);
    }
}
