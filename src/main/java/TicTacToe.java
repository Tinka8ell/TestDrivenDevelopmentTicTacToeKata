public class TicTacToe {

    private String board = ".".repeat(9);

    public String Turn(String input) {
        return "Player X has taken: A1";
    }

    @Override
    public String toString() {
        return " ABC" +
                "\n1" + board.substring(0, 3) +
                "\n2" + board.substring(3, 6) +
                "\n3" + board.substring(6);
    }
}
