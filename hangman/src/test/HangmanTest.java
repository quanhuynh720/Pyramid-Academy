import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class HangmanTest {

    Hangman hangman;

    @BeforeEach
    void setUp() {
        hangman = new Hangman();
    }

    @DisplayName("Test getRandomNumber")
    @Test
    void getRandom() {
        int random = Hangman.getRandomNumber(15,1);
        assertTrue(random <= 20 && random >= 1, "Test 1 failed");
    }

    @DisplayName("Test getGuess")
    @Test
    void getGuess() {
        assertEquals(0, hangman.getGuess(), "Test 2 failed");
    }

    @DisplayName("Test list")
    @Test
    void testList() {
        ArrayList<String> list = new ArrayList();
        Collections.addAll(list, "dog","cat","pig","eat","ink","fig","hat","jug","sit","tag","urn","war","van","kit","may");

        assertNotNull(list, "list is null");

        assertThat(String.valueOf(list.contains(hangman.hangWord())), true); //check if handWord() can return word within list
    }

    @AfterEach
    void tearDown() {
    }


}
