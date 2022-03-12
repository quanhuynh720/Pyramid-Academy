import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class Test {
    User user;
    BoardingPass bp;

    @BeforeEach
    void setUp() {
        user = new User();
        bp = new BoardingPass();
    }

    @DisplayName("Boarding Pass test")
    @org.junit.jupiter.api.Test
    void getETA() {
        assertEquals("2 hours", bp.getETA(), "getETA didn't work");
    }


    @AfterEach
    void tearDown() {

    }
}

