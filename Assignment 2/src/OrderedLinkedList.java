/**
 * Represents an ordered linked-list where elements are stored in ascending order
 * based on their natural ordering. It has two private fields and has four public methods.
 * The type parameter <T> should be comparable.
 * @param <T> the type of elements stored in this list, which extends Comparable<T>
 */
public class OrderedLinkedList<T extends Comparable<T>> {

    /** Reference to the head/front of the list. */
    private Node<T> head;

    /** The size of the list. */
    private int size;

    /**
     * Creates a new empty OrderedLinkedList by setting head to point to null.
     */
    public OrderedLinkedList() {
        this.head = null;
    }

    /**
     * Inserts a new data element into the list in its correct order.
     * It begins by inserting newData into a newNode which points to null.
     * Each insert into the linked list will increase the size field by one.
     * @param newData the data element to be inserted
     */
    public void insert(T newData) {

        Node<T> newNode = new Node<>(newData, null);

        if (head == null) {
            head = newNode;
            size += 1;
            return;
        }
        Node<T> curr = head;
        Node<T> prev = null;

        /*  While curr is not null and the new data is smaller than the data in the list, prev moves to curr, and curr moves to its pointer */
        while (curr != null && newData.compareTo(curr.getData()) <= 0) {
            prev = curr;
            curr = curr.getNext();
        }

        if (prev == null) {
            newNode.setNext(head);
            head = newNode;
        } else {
            newNode.setNext(curr);
            prev.setNext(newNode);
        }
        size += 1;
    }

    /**
     * Returns the data at the specified index in the list.
     * Throws IndexOutOfBoundsException if the index is out of bounds.
     * @param i the index of the element to retrieve
     * @return the data at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get(int i) {

        Node<T> curr = head;
        int counter = 0;

        /* While curr is not null, curr traverses the list until the counter is equal to i*/
        while (curr != null) {
            if (counter == i) {
                return curr.getData();
            }
            curr = curr.getNext();
            counter++;
        }

        throw new IndexOutOfBoundsException();
    }

    /**
     * Returns the current size of the list.
     * @return the size of the list
     */
    public int getSize() {
        return size;
    }

}
