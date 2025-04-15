import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class studentScoreECPTest {
    @Test
    public void testValidFailingScore() {
        System.out.println("Testing if 25 is valid.");
        assertTrue(studentScore.validScore(25));
        assertEquals("Student FAILED", studentScore.evaluateScore(25));
    }

    // Class 2 – Valid (Pass)
    @Test
    public void testValidPassingScore() {
        System.out.println("Testing if 75 is valid");
        assertTrue(studentScore.validScore(75));
        assertEquals("Student PASSED", studentScore.evaluateScore(75));
    }

    // Class 3 – Invalid (<0)
    @Test
    public void testInvalidLowScore() {
        System.out.println("Testing if -10 is invalid");
        assertFalse(studentScore.validScore(-10));
        assertEquals("Invalid score.", studentScore.evaluateScore(-10));
    }

    // Class 4 – Invalid (>100)
    @Test
    public void testInvalidHighScore() {
        System.out.println("Testing if 150 is invalid");
        assertFalse(studentScore.validScore(150));
        assertEquals("Invalid score.", studentScore.evaluateScore(150));
    }
}
