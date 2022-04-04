import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    private TicTacToe game;

    @BeforeEach
    public void setup(){
        game = new TicTacToe();
    }

    @Test
    public void checkToString(){
        String expect = " ABC\n1...\n2...\n3...";
        assertEquals(expect, game.toString(), "Empty board");
    }

    @Test
    public void checkTurn1(){
        String input = "A1";
        String expect = "Player X has taken: A1";
        assertEquals(expect, game.Turn(input), "First turn to top right");
    }

}