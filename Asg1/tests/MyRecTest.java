import static org.junit.Assert.*;

import org.junit.Test;

/**
 * MyRec Test Class
 * 
 * @author Nic Falcione
 * @version 9/6/17
 */
public class MyRecTest {

    /**
     * Test to check a valid factorial output
     */
    @Test
    public void testFactValid() {
        MyRec test = new MyRec();

        Integer toTest = 4;
        Integer actual = test.fact(toTest);
        Integer expected = 24;

        assertEquals(expected, actual);
    }

    /**
     * Test to check if exception is thrown
     */
    @Test
    public void testFactInvalid() {
        MyRec test = new MyRec();
        Integer toTest = -1;
        Integer actual;
        try {
            actual = test.fact(toTest);
            fail("Did not catch exception!");
        }

        catch (IllegalArgumentException e) {
            actual = -1;
            assertEquals(actual, toTest);
            return;
        }
    }

    /**
     * Check for valid palindrome
     */
    @Test
    public void testIsPalValid() {
        MyRec test = new MyRec();

        String s = "racecar";

        assertTrue(test.isPal(s));
    }

    /**
     * Check for a non-palindrome
     */
    @Test
    public void testIsNotPal() {
        MyRec test = new MyRec();

        String s = "spoon";

        assertFalse(test.isPal(s));
    }

    /**
     * Check for base cases
     */
    @Test
    public void testIsPalBaseCases() {
        MyRec test = new MyRec();

        String s = "s";
        String r = "";

        assertTrue(test.isPal(s));
        assertTrue(test.isPal(r));
    }

    /**
     * Check for empty string
     */
    @Test
    public void testIsIntEmpty() {
        MyRec test = new MyRec();

        String s = "";

        assertFalse(test.isInt(s));
    }

    /**
     * Check for valid int in String
     */
    @Test
    public void testIsIntValid() {
        MyRec test = new MyRec();

        String s = "4000";

        assertTrue(test.isInt(s));
    }
    
    /**
     * Check for valid int in String
     */
    @Test
    public void testIsIntValidOne() {
        MyRec test = new MyRec();

        String s = "4";

        assertTrue(test.isInt(s));
    }
    
    /**
     * Check for valid int in String
     */
    @Test
    public void testIsIntInvalidSign() {
        MyRec test = new MyRec();

        String s = "+";
        String r = "-";

        assertFalse(test.isInt(s));
        assertFalse(test.isInt(r));
    }

    /**
     * Check for valid neg int in String
     */
    @Test
    public void testIsIntValidNeg() {
        MyRec test = new MyRec();

        String s = "-400";

        assertTrue(test.isInt(s));
    }

    /**
     * Check for a non-int in String
     */
    @Test
    public void testIsIntInvalid() {
        MyRec test = new MyRec();

        String s = "4op1";

        assertFalse(test.isInt(s));
    }

}
