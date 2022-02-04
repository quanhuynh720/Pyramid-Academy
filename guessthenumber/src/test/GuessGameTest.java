import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class GuessGameTest {

    GuessGame guessGame;

    @BeforeEach
    void setUp() {
        guessGame = new GuessGame();
    }

    @DisplayName("Test getTries")
    @Test
    void getTries(){
        assertEquals(6, guessGame.getTries(), "Test 1 failed");
    }

    @DisplayName("Test greeting")
    @Test
    void greeting() {
        assertEquals("\n Well, Quan, I am thinking of a number between 1 and 20. \n Please take a guess. ", guessGame.greeting("Quan"), "Test 2 failed");
    }

    @DisplayName("Test getRandom")
    @Test
    void getRandom(){
        int random = GuessGame.getRandomNumber(20,1);
        assertTrue(random <= 20 && random >= 1, "Test 3 failed");
    }

    @AfterEach
    void tearDown() {
    }

}
