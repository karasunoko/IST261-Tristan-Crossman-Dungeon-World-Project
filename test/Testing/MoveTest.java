package Testing;

import DungeonWorld.Move;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    @Test
    void testToString() {
        Move mTest = new Move("Test", "Test description.");
        assertEquals("Test: Test description.", mTest.toString());
    }

    @Test
    void getDescription() {
        Move mTest = new Move();
        assertEquals("default", mTest.getDescription());
    }

    @Test
    void setDescription() {
        Move mTest = new Move();
        mTest.setDescription("Test description.");
        assertEquals("Test description.", mTest.getDescription());
    }

    @Test
    void getName() {
        Move mTest = new Move();
        assertEquals("", mTest.getName());
    }

    @Test
    void setName() {
        Move mTest = new Move();
        mTest.setName("Test");
        assertEquals("Test", mTest.getName());
    }
}