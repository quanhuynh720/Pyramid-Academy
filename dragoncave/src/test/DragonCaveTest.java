import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DragonCaveTest {

    DragonCave dragonCave;

    @BeforeEach
    void setUp() {
        dragonCave = new DragonCave();
    }

    @DisplayName("Test getTreasure")
    @Test
    void getTreasure() {
        assertEquals("mighty glowing sword", dragonCave.getTreasure(), "Test 1 failed");
    }

    @DisplayName("Test startingText")
    @Test
    void startingText() {
        assertEquals("...Welcome traveller. You are in a land full of dragons." +
                "\n In front of you, you see two caves. In one cave, the dragon is friendly" +
                "\n and will share his treasure with you. The other dragon is greedy and hungry" +
                "\n and will eat you on sight. Which cave will you go into? (1 or 2): ", dragonCave.startingText(), "Test 2 failed");
    }

    @AfterEach
    void tearDown() {
    }
}
