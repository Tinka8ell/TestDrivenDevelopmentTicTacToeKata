import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    private TicTacToe game;

    @BeforeEach
    public void setup(){
        game = new TicTacToe();
    }

    @Test
    public void checkEmptyBoardToString(){
        String expect = " ABC\n1...\n2...\n3...";
        assertEquals(expect, game.toString(), "Empty board");
    }

    @ParameterizedTest
    @CsvSource({
            "A1, 1X.., 2..., 3...",
            "B1, 1.X., 2..., 3...",
            "C1, 1..X, 2..., 3...",
            "A2, 1..., 2X.., 3...",
            "B2, 1..., 2.X., 3...",
            "C2, 1..., 2..X, 3...",
            "A3, 1..., 2..., 3X..",
            "B3, 1..., 2..., 3.X.",
            "C3, 1..., 2..., 3..X",
    })
    public void checkBoardAfterTurn1(String input, String row1, String row2, String row3){
        game.turn(input);
        String expected = " ABC\n" + row1 + "\n" + row2 + "\n" + row3;
        String result = game.toString();
        assertEquals(expected, result);
    }

    @Test
    public void checkEmptyInputToTurn(){
        String expect = "Player X has taken: null";
        String result = game.turn(null);
        assertNotEquals(expect, result);
        assertTrue(result.startsWith("Bad"));
        String expect2 = "Player X has taken: ";
        String result2 = game.turn("");
        assertNotEquals(expect2, result2);
        assertTrue(result2.startsWith("Bad"));
    }

    @ParameterizedTest
    @CsvSource({
            "A1", "A2", "A3",
            "B1", "B2", "B3",
            "C1", "C2", "C3",
    })
    public void checkTurn1(String input){
        String expected = "Player X has taken: " + input;
        assertEquals(expected, game.turn(input));
    }

    @ParameterizedTest
    @CsvSource({
            "A4", "D2", "3A",
            "BB", "22", "Lemon",
            ".", "C", "3",
    })
    public void checkBadGrid(String input){
        String expected = "Player X has taken: " + input;
        String result = game.turn(input);
        assertNotEquals(expected, result);
        assertTrue(result.startsWith("Bad"));
    }

    @Test
    public void checkTurn2(){
        String expected = "Player O has taken: A2";
        game.turn("A1");
        assertEquals(expected, game.turn("A2"));
    }

    @Test
    public void checkBoardAfter2Turns(){
        String expect = " ABC\n1X..\n2O..\n3...";
        game.turn("A1");
        game.turn("A2");
        assertEquals(expect, game.toString());
    }

    @Test
    public void checkBadTurn2Same(){
        String expected = "Player O has taken: A2";
        game.turn("A1");
        String result = game.turn("A1");
        assertNotEquals(expected, result);
        assertTrue(result.startsWith("Bad"));
    }

    @Test
    public void checkBadTurn2SameAndDifferent(){
        String expected = "Player O has taken: A2";
        game.turn("A1");
        game.turn("A1"); // should fail, but allow next
        assertEquals(expected, game.turn("A2"));
    }

    @Test
    public void checkForWin(){
        String expected = "Player X has won";
        game.turn("A1");
        game.turn("A2");
        game.turn("B1");
        game.turn("B2");
        assertEquals(expected, game.turn("C1"));
    }

    @Test
    public void checkForDraw(){
        String expected = "Draw";
        game.turn("A1"); //X
        game.turn("A3"); //O
        game.turn("A2"); //X
        game.turn("B1"); //O
        game.turn("B2"); //X
        game.turn("C2"); //O
        game.turn("B3"); //X
        game.turn("C3"); //O
        assertEquals(expected, game.turn("C1"));
    }

    @Test
    public void checkGameOverAfterWin(){
        String expected = "Game is over";
        game.turn("A1");
        game.turn("A2");
        game.turn("B1");
        game.turn("B2");
        game.turn("C1");
        assertEquals(expected, game.turn("C2"));
    }

    @Test
    public void checkGameOverAfterDraw(){
        String expected = "Game is over";
        game.turn("A1"); //X
        game.turn("A3"); //O
        game.turn("A2"); //X
        game.turn("B1"); //O
        game.turn("B2"); //X
        game.turn("C2"); //O
        game.turn("B3"); //X
        game.turn("C3"); //O
        game.turn("C1"); //X
        assertEquals(expected, game.turn("C1"));
    }

}