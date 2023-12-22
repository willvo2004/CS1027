import java.util.NoSuchElementException;

/**
 * @author William Vo
 * A class that represents an iterator for a unique ordered linked list. The iterator implements the CopyableIterator interface
 * to allow for copying.
 * @param <T> The type of elements stored in the iterator.
 */
public class UOLIterator<T> implements CopyableIterator<T> {

    // The current node in the iteration.
    LinearNode<T> curr;

    /**
     * Constructs a new iterator starting at the specified node.
     * @param node The starting node for the iterator.
     */
    public UOLIterator(LinearNode<T> node) {
        curr = node;
    }

    /**
     * Checks if there are more elements in the iterator. (If curr is pointing to null)
     * @return true if there are more elements, false otherwise.
     */
    public boolean hasNext() {
        return curr != null; // if curr is null, there are no more elements to visit.
    }

    /**
     * Retrieves the next element of type T to be returned in the iterator and then
     * updates the value of curr to the next node in the list
     * @return The next element in the iterator.
     * @throws NoSuchElementException if there are no more elements to visit.
     */
    public T next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException("iterator empty");
            }
            T item = curr.getData();
            curr = curr.getNext();
            return item;
    }

    /**
     * Creates a copy of the iterator that points to the same node as curr.
     * @return A new iterator with the same current position as the original.
     */
    @Override
    public CopyableIterator<T> copy() {
            CopyableIterator<T> newIterator = new UOLIterator<>(curr);
            return newIterator;
    }
}
