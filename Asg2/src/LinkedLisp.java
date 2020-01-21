/**
 * Class implementing the LispADT. Creates Linked list with various methods that
 * can be used to manage the list
 * 
 * @author Nic Falcione
 * @version 10/01/17
 */
public class LinkedLisp implements LispADT {

    private int size;
    private Link head;
    private Link tail;
    private Link current;

    /**
     * Constructor to create a LinkedLisp with a specified size
     * 
     * @param size
     *            size of the LinkedLisp to be initialized
     */
    public LinkedLisp(int size) {
        this.size = size;
        tail = new Link(null);
        current = tail;
        head = new Link(tail);
    }

    /**
     * Constructor to create a LinkedLisp
     */
    public LinkedLisp() {
        this.size = 0;
        tail = new Link(null);
        current = tail;
        head = new Link(tail);
    }

    /**
     * Insert the Object referred to by c into this LispADT at the current
     * position.
     * 
     * @param c
     *            reference to the Object which is to be inserted
     * @return the changed LispADT
     */
    @Override
    public LispADT add(Object c) {
        current.setNext(new Link(current.getValue(), current.next()));
        current.setValue(c);
        if (tail == current) {
            tail = current.next();
        }
        size++;
        return this;
    }

    /**
     * Return the current position. First position is 0, last possible position
     * is numOfElements (to allow adding after the last element). The current
     * position in an empty list is 0.
     * 
     * @return position of current element
     */
    public Integer curPos() {
        Link temp = head.next();

        int cnt;

        for (cnt = 0; current != temp; cnt++) {
            temp = temp.next();
        }
        return cnt;
    }

    /**
     * Return the element at the current position of this LispADT.
     * 
     * @return the current element
     * @throws RuntimeException
     *             when it is not possible to return the current element
     */
    @Override
    public Object get() throws RuntimeException {
        if (current == tail) {
            throw new RuntimeException();
        }
        return current.getValue();
    }

    /**
     * Move the current position to the given position of this list. Remember
     * that the first position is zero. Problem cases should fail silently and
     * NO changes should be made.
     * 
     * @param p
     *            index for where the cursor should be placed in the list
     * @return the possibly changed LispADT
     */
    @Override
    public LispADT moveTo(Integer p) {
        if (p < new Integer(0) || (p > size)) {
            return this;
        }
        current = head.next();
        for (int i = 0; i < p; i++) {
            current = current.next();
        }
        return this;
    }

    /**
     * Move the current position one element towards the tail of this LispADT.
     * Problem cases should fail silently and NO changes should be made.
     * 
     * @return the possibly changed LispADT
     */
    @Override
    public LispADT next() {
        if (current != tail) {
            current = current.next();
        }
        return this;
    }

    /**
     * Move the current position one element towards the head of this LispADT.
     * Problem cases should fail silently and NO changes should be made.
     * 
     * @return the possibly changed LispADT
     */
    @Override
    public LispADT prev() {
        if (head.next() == current) {
            return this;
        }
        Link temp = head;

        while (temp.next() != current) {
            temp = temp.next();
        }
        current = temp;
        return this;
    }

    /**
     * Remove the current character from this LispADT. The changed LispADT
     * should be returned. Problem cases should fail silently and NO changes
     * should be made.
     * 
     * @return the possibly changed LispADT
     */
    @Override
    public LispADT remove() {
        if (current == tail) {
            return this;
        }

        current.setValue(current.next().getValue());

        if (current.next() == tail) {
            tail = current;
        }

        current.setNext(current.next().next());

        size--;
        return this;
    }

    /**
     * Determine the number of elements in this list.
     * 
     * @return number of elements in this list
     */
    @Override
    public Integer size() {
        return size;
    }

    /**
     * Determine if this LispADT is equal to the given LispADT. Two LispADTs are
     * equal if and only if they have the same elements, in the same order, and
     * have the same current element.
     * 
     * @param o
     *            the LispADT to check for equality with this LispADT
     * @return Whether the current object equals the parameter
     */
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        LispADT temp = (LispADT) o;
        return (this.toString().equals(temp.toString()));
    }

    /**
     * Get the String representation of this LispADT. The String representation
     * must follow these rules:
     * 
     * @return the String representation of the LinkedLisp in order
     */
    public String toString() {
        if (size() == 0) {
            return ("< | >");
        }

        String str = "< ";
        Link temp = head;
        int cnt = 0;
        while (temp.next() != tail) {
            cnt++;
            temp = temp.next();
            if (temp == current) {
                if (temp.next() != tail) {
                    str += "| " + temp.getValue() + " , ";
                }
                else {
                    str += "| " + temp.getValue();
                }
            } 
            
            else {
                if (cnt < size() && temp.next() != current) {
                    str += temp.getValue() + " , ";
                } 
                else if (cnt < size() && temp.next() == current) {
                    str += temp.getValue() + " ";
                }
                else {
                    str += temp.getValue();
                }
                if (current == tail) {
                    str += " |";
                }
            }
        }
        str += " >";
        return str;
    }

}
