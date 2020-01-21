/**
 * MyRec Class
 * 
 * @author Nic Falcione
 * @version 9/6/17
 */
public class MyRec implements RecursionADT {

    private boolean first = true;

    /**
     * Returns the factorial of the given Integer
     * 
     * @param n
     *            factorial coefficient
     * @return factorial
     */
    @Override
    public Integer fact(Integer n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        if (n < 2) {
            return 1;
        }

        return n * fact(n - 1);
    }

    /**
     * Checks to see if the given string is a palindrome
     * 
     * @param s
     *            string to check
     * @return whether string is a palindrome
     */
    @Override
    public Boolean isPal(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }

        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPal(s.substring(1, s.length() - 1));
        }

        else {
            return false;
        }
    }

    /**
     * Checks to see if the given string is an int
     * 
     * @param s
     *            String to check
     * @return whether string is a valid int
     */
    @Override
    public Boolean isInt(String s) {
        if (s.length() == 0) {
            first = true;
            return false;
        }

        if (s.length() == 1 && Character.isDigit(s.charAt(0))) {
            first = true;
            return true;
        }

        if ((s.charAt(0) == '+' || s.charAt(0) == '-') && first) {
            first = false;
            return isInt(s.substring(1));
        }

        if (Character.isDigit(s.charAt(0))) {
            first = true;
            return isInt(s.substring(1));
        }

        else {
            first = true;
            return false;
        }
    }

}
