/**
 * Class to contain links and values for a LinkedLisp
 * 
 * @author Nic Falcione
 * @version 10/02/17
 */
public class Link {

    private Object val;
    private Link l;

    /**
     * Constructor to create a new Link with a value
     * 
     * @param val
     *            value of the element placed in the link
     * @param link
     *            the link associated
     */
    protected Link(Object val, Link link) {
        this.val = val;
        this.l = link;
    }

    /**
     * Constructor to create a new Link with a null value
     * 
     * @param link
     *            the link associated
     */
    protected Link(Link link) {
        this.val = null;
        this.l = link;
    }

    /**
     * Sets the value of a link in the list
     * 
     * @param e
     *            Object to be set to the value contained in the link
     * @return the object set in the link
     */
    protected Object setValue(Object e) {
        this.val = e;
        return e;
    }

    /**
     * Returns the object contained in the link
     * 
     * @return The Object contained in the element of the Link
     */
    protected Object getValue() {
        return val;
    }

    /**
     * Returns the link to the next object in the list
     * 
     * @return The next link
     */
    protected Link next() {
        return l;
    }

    /**
     * Sets the next link in the list
     * 
     * @param n
     *            Link to be connected to the current link
     * @return returns the link given in the parameter
     */
    protected Link setNext(Link n) {
        l = n;
        return n;
    }

}
