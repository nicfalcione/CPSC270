/**
 * <!-- ASG1
 * 
 * <pre>
 * INSTRUCTIONS FOR READING THIS ASSIGNMENT:
 * 1. In Eclipse, right-click the imported file and select Export/Java/JavaDoc
 * 2. Note the destination (look for this in the bottom 1/3 of the dialog box
 * 3. Click Finish
 * 4. Find the index.html file and double click it.
 * </pre>
 * 
 * -->
 * <h1>Asg1: Recursion</h1>
 * <h2>Objectives</h2>
 * <p>
 * <ul>
 * <li>practice implementing recursive methods</li>
 * <li>practice how to write JUnit tests</li>
 * <li>practice how to write readable code according to best practices
 * </ul>
 * </p>
 * <h2>Introduction</h2>
 * <p>
 * The RecursionADT defines the API for a RecursionDemo. A RecursionDemo has no
 * data fields, only methods.
 * </p>
 * <p>
 * Your task is to implement this ADT, develop a JUnit test class, and document
 * both using Javadoc.
 * </p>
 * <h2>Instructions</h2>
 * <p>
 * <ul>
 * <li>Review Asg0's example code in src and tests.</li>
 * <li>Study the api so you know what methods to implement and what they
 * do.</li>
 * <li>Write the Javadoc for the JUnit class.</li>
 * <li>Implement the JUnit tests for the ADT described by this API.</li>
 * <li>Write the Javadoc for your implementation class. Note: you must use the
 * eclipse commands to create this class from this ADT. Do not change the
 * generated comments for the methods. Only modify the class javadoc, and write
 * javadoc for any non-public methods and fields you add.</li>
 * <li>Implement the ADT described by this API.</li>
 * <li>You may NOT use any pre-existing classes which essentially implement this
 * ADT.</li>
 * <li>You MUST implement this ADT using recursion. No credit will be given for
 * non-recursive solutions.</li>
 * <li>Submit your files to Web-CAT using the eclipse menu "Project->Submit
 * Assignment..."</li>
 * <li>To see my comments after I've graded your work, or to see your results at
 * any time, login to http://web-cat.cs.vt.edu</li>
 * </ul>
 * </p>
 * <h2>Basic Tips</h2>
 * <p>
 * Use the development process described in class and the slides. For example,
 * develop tests for a method, implement the method, run the tests. Do this
 * until the method passes the tests. Go on to the next method.
 * </p>
 * </p>
 * <h2>NOTES</h2>
 * <p>
 * <li>Any submission that that uses pre-existing classes that essentially
 * implement this ADT will receive NO CREDIT.</li>
 * <li>You may submit as many times as you like until the deadline.</li>
 * <li>The grade of your latest submission will be the one recorded.</li>
 * <li><b>I have modified the Web-CAT grader to compute the grades
 * as we talked about in class. The CNU Weighted score is correct.</b></li>
 * </ul>
 * </p>
 * <h2>CHECKLISTS</h2>
 * <p>
 * Check that you have done all the following.
 * <table border="1">
 * <tr>
 * <td>DONE?</td>
 * <td>TASK</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>The implementing class for this assignment is named MyRec</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>All methods specified in the ADT are implemented</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td><b>Except for constructors (which MUST be public)</b>, any non-ADT
 * methods are NOT declared public</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Fields, if any, are NOT declared public</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Code is formatted as described in howToWriteReadableCode</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Javadoc is present in the implementation and JUnit class headers as well
 * as all non-private fields and ALL methods</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Class header javadoc must include a brief description of the class, and
 * the &#64;author and &#64;version tags</td>
 * </tr>
 * </table>
 * </p>
 * <p>
 * Check that you read and followed these how-to items in piazza.
 * </p>
 * <table border="1">
 * <tr>
 * <td>DONE?</td>
 * <td>TASK</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Read: how to write JUnit tests</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Read: how to write and format readable Java (and satisfy Web-CAT's format
 * checks)</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Watch: video: setup eclipse to format your code for Web-CAT</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Read: how to setup Eclipse for Web-CAT</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Read: how to submit your assignment to Web-CAT from within Eclipse</td>
 * </tr>
 * <tr>
 * <td>.</td>
 * <td>Read: how to find formatting or code coverage errors in your source
 * code</td>
 * </tr>
 * </table>
 * 
 * @author acsiochi
 * @version 20170905
 */
public interface RecursionADT {

    /**
     * 
     * Compute the factorial of n. Remember that 0! is 1, and that n! is
     * undefined for n < 0.
     *
     * @param n
     *            compute the factorial of this number.
     * @return n!
     * @throws IllegalArgumentException if n < 0
     */
    public Integer fact(Integer n) throws IllegalArgumentException;

    /**
     * 
     * Determine if the given String is a palindrome. Do not ignore
     * spaces or punctuation. For example "I am.ma I" is a palindrome.
     *
     * @param s
     *            determine if this is a palindrome
     * @return true if s is a palindrome, false else.
     */
    public Boolean isPal(String s);

    /**
     * Determine if the given String is an Int. An Int is a String whose
     * first character is a +, -, or a digit, and whose rest of the String
     * is a sequence of digits.
     *
     * @param s determine if this is an Int
     * @return true if s is an Int, false else
     */
    public Boolean isInt(String s);

}
