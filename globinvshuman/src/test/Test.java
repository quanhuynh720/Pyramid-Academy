import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class Test {
    Goblin goblin;

    @BeforeEach
    void setUp() {
        goblin = new Goblin();
    }

    @DisplayName("Goblin test")
    @org.junit.jupiter.api.Test
    void getHealth() {
        assertEquals(30, goblin.getHealth(), "Goblin health test didn't work");
    }

    @DisplayName("Test getRandomNumber")
    @org.junit.jupiter.api.Test
    void getRandom() {
        int random = Goblin.getRandomNumber(5,1);
        assertTrue(random <=5 && random >= 1, "Test 1 failed");
    }

    @DisplayName("Test list")
    @org.junit.jupiter.api.Test
    void drop() {
        ArrayList<String> dropItems = new ArrayList();
        Collections.addAll(dropItems, "leather vest","rusty dagger","broken helmet","Goblin eyeball","smelly boots");

        assertNotNull(dropItems, "list is null");

        assertThat(String.valueOf(dropItems.contains(goblin.drops())), true); //check if handWord() can return word within list
    }

    @AfterEach
    void tearDown() {

    }







}
