public class OrderedLinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private int size;

    public OrderedLinkedList() {
        this.head = null;
    }

    public void insert(T newData) { // if x.compareTo(y) > 0, x is larger. y are elements already in the list

        Node<T> newNode = new Node<>(newData, null);
        Node<T> curr = head;
        Node<T> prev = null;

        if (head == null) { // handles null pointer exception
            head = newNode;
            return;
        }

        while (curr.getNext() != null && newData.compareTo(curr.getData()) <= 0) {
            prev = curr;
            curr = curr.getNext();
        }
        if (curr.getNext() == null) { // if newData is the smallest
            curr.setNext(newNode);
        }
        else {
            if (prev == null) {
                newNode.setNext(curr);
            } else {
                prev.setNext(newNode);
                newNode.setNext(curr);
            }

        }
    }

    public T get(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> curr = head;
        int counter = 0;

        while (curr != null) {
            if (counter == i) {
                return curr.getData();
            }
            curr = curr.getNext();
            counter++;
        }

        throw new IndexOutOfBoundsException();
    }
    public int getSize() {
        Node<T> curr = head;
        int counter = 0;

        while (curr != null) {
            counter++;
            if (curr.getNext() == null) {
                return 1;
            }
            else {
                curr = curr.getNext();
            }
        }

        return counter;
    }

}
