/**
 * A class that represents an ordered linked list that is composed of unique values.
 * The class implements UniqueOrderedListADT<T>, SimpleIterable<T>, and inherits from
 * Comparable<T> to maintain sorted order
 * @param <T> The type of elements stored in the linked list.
 */
public class UniqueOrderedList<T extends Comparable<T>> implements UniqueOrderedListADT<T>, SimpleIterable<T> {

	private int size;
	private LinearNode<T> head;
	public UniqueOrderedList() {
		this.head = null;
		size = 0;
	}

	public UniqueOrderedList(T[] data) { 
		this();
		for (int i = 0; i < data.length; i++) {
			this.add(data[i]);
		}
	}

	public boolean contains (T element) { 

		LinearNode<T> curr = this.head;
		while (curr != null  && curr.getData().compareTo(element) <= 0)  {
			if (curr.getData().equals(element)) { 
				return true;
			} else {
				curr = curr.getNext();
			}
		}
		return false;

	}

	public boolean add(T element) { 

		if (this.contains(element)) { 
			return false;
		} else {

			if (this.head == null || this.head.getData().compareTo(element) > 0) {
				this.head = new LinearNode<T>(element,head);
			} else {
				LinearNode<T> curr = this.head;
				LinearNode<T> prev = null;

				while (curr != null && curr.getData().compareTo(element) < 0) { 
					prev = curr;
					curr = curr.getNext();
				}

				prev.setNext(new LinearNode<T> (element, curr));
			}
		}
		size+=1;
		return true;
	}
	
	public int size() {
		return this.size;
	}

	/**
	 * Creates a unique ordered list iterator that points to that should always point to the head of the list
	 * @return A new iterator that points to the head of the list.
	 */
	@Override
	public CopyableIterator<T> iterator() {
		CopyableIterator<T> iterator = new UOLIterator<>(head);
		return iterator;
	}
}
