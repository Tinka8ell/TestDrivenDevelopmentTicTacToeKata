public class TicTacToe {

    private String board = ".".repeat(9);
    private boolean xIsNext = true;

    public String Turn(String input) {
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
        return "Player " + player + " has taken: " + input;
    }

    @Override
    public String toString() {
        return " ABC" +
                "\n1" + board.substring(0, 3) +
                "\n2" + board.substring(3, 6) +
                "\n3" + board.substring(6);
    }
}
