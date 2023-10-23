/**
 * Defines a generic Node in a linked list.
 * A Node will contain data of generic type <T> and reference to the next Node in the list.
 * It has two private fields, and four public methods.
 * @author William Vo
 * @param <T> the type of data to be stored in this node
 */
public class Node <T> {

    /** Data stored in this Node */
    private final T data;
    /** Reference to the next Node in the linked list */
    private Node<T> next;

    /**
     * Creates a new Node with the given data and reference to the next Node.
     * @param data the data to be stored in this Node.
     * @param next the next Node in the list
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Returns the next Node in the list.
     * @return the next Node
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Returns the data stored in this Node.
     * @return the data of this Node
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the reference to the next Node in the list.
     * @param next the next Node to be set
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
