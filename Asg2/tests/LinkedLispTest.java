import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The test class to see if LinkedLisp methods are working correctly
 * 
 * @author Nic Falcione
 * @version 10/01/17
 */
public class LinkedLispTest {

    /**
     * Test to check to see if the constructor is working properly
     */
    @Test
    public void constructorCheck() {
        LispADT temp = new LinkedLisp(4);
        temp.add(new Character('c'));

        assertEquals(temp.size(), new Integer(5));
    }

    /**
     * Test to check the add method on an empty LinkedLisp
     */
    @Test
    public void addToEmptyList() {
        LispADT temp = new LinkedLisp();
        temp.add(new Character('c'));

        Character actual = (Character) temp.get();
        Character expected = new Character('c');

        assertEquals(temp.size(), new Integer(1));
        assertEquals(actual, expected);
    }

    /**
     * Test to check the add method on a LinkedLisp
     */
    @Test
    public void addToNonEmptyList() {
        LispADT temp = new LinkedLisp();
        temp.add("dope");
        temp.add("dope");
        temp.add("dope");

        String expected = "dope";
        String actual = (String) temp.get();

        assertEquals(temp.size(), new Integer(3));
        assertEquals(actual, expected);
    }

    /**
     * Test to check if the get method returns the correct element
     */
    @Test
    public void getAddedElement() {
        LispADT temp = new LinkedLisp();
        temp.add("dope");

        String expected = "dope";
        String actual = (String) temp.get();

        assertEquals(temp.size(), new Integer(1));
        assertEquals(actual, expected);
    }

    /**
     * Test to check if the get method throws a RuntimeException
     */
    @Test(expected = RuntimeException.class)
    public void getThrowsException() {
        LispADT temp = new LinkedLisp();
        assertNotNull(temp);
        temp.get();
    }

    /**
     * Checks if current position is zero on an empty list
     */
    @Test
    public void zeroPositionWhenSizeZero() {
        LispADT temp = new LinkedLisp();
        assertEquals(temp.curPos(), new Integer(0));
    }

    /**
     * Checks if current position is zero on an list after creation
     */
    @Test
    public void zeroPositionAfterCreation() {
        LispADT temp = new LinkedLisp();
        temp.add(new Integer(0));
        temp.add(new Long(0));

        assertEquals(temp.curPos(), new Integer(0));
    }

    /**
     * Checks if current position changes with next method
     */
    @Test
    public void currentPositionChangeAfterNext() {
        LispADT temp = new LinkedLisp();
        temp.add(new Integer(0));
        temp.add(new Integer(0));
        temp.next();

        assertEquals(temp.curPos(), new Integer(1));
    }

    /**
     * Test to check that inputting a position before the start of the list does
     * not change the current position
     */
    @Test
    public void moveToBeforeStart() {
        LispADT temp = new LinkedLisp();
        temp.add("dope");
        temp.add(new Integer(0));

        LispADT before = temp;
        LispADT after = temp.moveTo(-1);

        assertEquals(temp.size(), new Integer(2));
        assertEquals(before, after);
    }

    /**
     * Test to check that inputting a position past the end of the list does not
     * change the current position
     */
    @Test
    public void moveToPastEnd() {
        LispADT temp = new LinkedLisp();
        temp.add("dope");
        temp.add(new Integer(0));

        LispADT before = temp;
        LispADT after = temp.moveTo(3);

        assertEquals(temp.size(), new Integer(2));
        assertEquals(before, after);
    }

    /**
     * Test to check that inputting a position changes the current position in
     * the list
     */
    @Test
    public void moveToPositionMiddle() {
        LispADT temp = new LinkedLisp();
        temp.add("dope");
        temp.add(new Integer(0));
        temp.add(new Character('s'));

        temp.moveTo(1);

        Integer expected = new Integer(0);
        Object actual = (Integer) temp.get();

        assertEquals(temp.size(), new Integer(3));
        assertEquals(expected, actual);
    }

    /**
     * Test to check that the current position is changed when the current Link
     * is no the tail
     */
    @Test
    public void nextElementValid() {
        LispADT temp = new LinkedLisp();
        temp.add("dope");
        temp.add(new Integer(0));
        temp.add(new Character('s'));

        temp.moveTo(0);
        temp.next();

        Integer expected = new Integer(0);
        Object actual = (Integer) temp.get();

        assertEquals(temp.size(), new Integer(3));
        assertEquals(expected, actual);
    }

    /**
     * Test to check that the current position is not changed when the current
     * Link is the tail
     */
    @Test
    public void nextDoesNotChangeCurrentWhenTail() {
        LispADT temp = new LinkedLisp();
        temp.add("dope");
        temp.add(new Integer(0));
        temp.add(new Character('s'));

        temp.moveTo(3);
        temp.next();

        Integer expected = 3;
        Integer actual = temp.curPos();

        assertEquals(temp.size(), new Integer(3));
        assertEquals(expected, actual);
    }

    /**
     * Test to check that the current position is changed when the current Link
     * is not the head
     */
    @Test
    public void prevElementValid() {
        LispADT temp = new LinkedLisp();
        temp.add("dope");
        temp.add(new Integer(0));
        temp.add(new Character('s'));

        temp.moveTo(2);
        temp.prev();

        Integer expected = new Integer(0);
        Object actual = temp.get();

        assertEquals(temp.size(), new Integer(3));
        assertEquals(expected, actual);
    }

    /**
     * Test to check that the current position is not changed when the current
     * Link is the head
     */
    @Test
    public void prevDoesNotChangeCurrentWhenHead() {
        LispADT temp = new LinkedLisp();

        temp.prev();

        assertEquals(temp.size(), new Integer(0));
    }

    /**
     * Makes sure the remove method does not change the List if it is empty
     */
    @Test
    public void testRemoveEmptyList() {
        LispADT temp = new LinkedLisp();

        LispADT before = temp;
        temp.remove();

        assertEquals(temp.size(), new Integer(0));
        assertEquals(before, temp);
    }

    /**
     * Makes sure the remove method does remove when non empty
     */
    @Test
    public void testRemoveNonEmptyList() {
        LispADT temp = new LinkedLisp();
        temp.add("dope");
        temp.add(new Integer(0));
        temp.add(new Character('s'));

        temp.remove();

        Integer expected = new Integer(0);
        Object actual = (Integer) temp.get();

        assertEquals(temp.size(), new Integer(2));
        assertEquals(expected, actual);
    }

    /**
     * Makes sure the remove method does remove when non empty and position is
     * changed
     */
    @Test
    public void testRemoveNonEmptyListNext() {
        LispADT temp = new LinkedLisp();
        temp.add("dope");
        temp.add(new Integer(0));
        temp.add(new Character('s'));

        temp.next();
        temp.next();
        temp.remove();

        assertEquals(temp.size(), new Integer(2));
    }

    /**
     * Checks to see if the size method returns the correct size of the list
     */
    @Test
    public void checkForCorrectSize() {
        LispADT temp = new LinkedLisp();
        temp.add("dope");
        temp.add(new Integer(0));
        temp.add(new Character('s'));

        assertEquals(temp.size(), new Integer(3));
    }

    /**
     * Checks to see if the equals method returns false mismatching types
     */
    @Test
    public void doeNotEqualMismatchingType() {
        LispADT temp = new LinkedLisp();
        temp.add("dope");
        temp.add(new Integer(0));
        temp.add(new Character('s'));

        Integer in = new Integer(0);

        assertFalse(temp.equals(in));
    }

    /**
     * Checks to see if the equals method returns false when comparing to null
     */
    @Test
    public void doeNotEqualNull() {
        LispADT temp = new LinkedLisp();
        Object l = null;

        assertFalse(temp.equals(l));
    }

    /**
     * Checks to see if the toString method returns correctly on an empty list
     */
    @Test
    public void toStringEmptyList() {
        LispADT temp = new LinkedLisp();
        String expected = "< | >";
        String actual = temp.toString();

        assertEquals(temp.size(), new Integer(0));
        assertEquals(expected, actual);
    }

    /**
     * Checks to see if the toString method returns correctly when current is
     * last
     */
    @Test
    public void toStringCurrentLast() {
        LispADT temp = new LinkedLisp();
        temp.add(new Character('a'));
        temp.moveTo(1);

        String expected = "< a | >";
        String actual = temp.toString();

        assertEquals(temp.size(), new Integer(1));
        assertEquals(expected, actual);
    }

    /**
     * Checks to see if the toString method returns correctly when current is in
     * the middle
     */
    @Test
    public void toStringCurrentMiddle() {
        LispADT temp = new LinkedLisp();
        temp.add(new Character('a'));
        temp.add(new Character('a'));
        temp.add(new Character('a'));
        temp.moveTo(2);

        String expected = "< a , a | a >";
        String actual = temp.toString();

        assertEquals(temp.size(), new Integer(3));
        assertEquals(expected, actual);
    }

    /**
     * Checks to see if the toString method returns correctly on an occupied
     * list
     */
    @Test
    public void toStringOccupiedList() {
        LispADT temp = new LinkedLisp();
        temp.add('c');
        temp.add('l');
        temp.add('l');

        String expected = "< | l , l , c >";
        String actual = temp.toString();

        assertEquals(temp.size(), new Integer(3));
        assertEquals(expected, actual);
    }
}
