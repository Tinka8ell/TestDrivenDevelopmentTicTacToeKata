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
        game.Turn(input);
        String expected = " ABC\n" + row1 + "\n" + row2 + "\n" + row3;
        String result = game.toString();
        assertEquals(expected, result);
    }

    @Test
    public void checkEmptyInputToTurn(){
        String expect = "Player X has taken: null";
        String result = game.Turn(null);
        assertNotEquals(expect, result);
        assertTrue(result.startsWith("Bad"));
        String expect2 = "Player X has taken: ";
        String result2 = game.Turn("");
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
        assertEquals(expected, game.Turn(input));
    }

    @ParameterizedTest
    @CsvSource({
            "A4", "D2", "3A",
            "BB", "22", "Lemon",
            ".", "C", "3",
    })
    public void checkBadGrid(String input){
        String expected = "Player X has taken: " + input;
        String result = game.Turn(input);
        assertNotEquals(expected, result);
        assertTrue(result.startsWith("Bad"));
    }

}