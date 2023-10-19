public class OrderedLinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private int size;

    public OrderedLinkedList() {
        this.head = null;
    }

    public void insert(T newData) { // if x.compareTo(y) > 0, x is larger. y are elements already in the list

        Node<T> newNode = new Node<>(newData, null);

        if (head == null) { // handles null pointer exception
            head = newNode;
            size += 1;
            return;
        }
        Node<T> curr = head;
        Node<T> prev = null;

        while (curr != null && newData.compareTo(curr.getData()) <= 0) {
            prev = curr;
            curr = curr.getNext(); // would this not throw a null pointer exception?
        }
        if (prev == null) {
            newNode.setNext(curr); // argument can curr or head? Because of line 19?
            head = newNode;
        } else {
            newNode.setNext(curr);
            prev.setNext(newNode);
        }
        size += 1;
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
        return size;
    }

}
