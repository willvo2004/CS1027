
public class DLQueue<T> implements QueueADT<T> {

	private int count;
	private DoubleNode<T> front, rear;
	
	public DLQueue () {
		count = 0;
		front = rear = null;
	}
	
	public void enqueue(T element) {
		DoubleNode<T> newNode = new DoubleNode<>(element);
		if (count == 0) {
			front = newNode;
			rear = newNode;
			count ++;
			return;
		}
		rear.setNext(newNode);
		newNode.setPrev(rear);
		rear = newNode;
		count ++;
	}

	public T dequeue() throws EmptyCollectionException {
		if (count == 0) {
			throw new EmptyCollectionException("");
		}
		else if (count == 1) {
			T returnValue = front.getElement();
			front = null;
			rear = null;
			count --;
			return returnValue;
		}
		else {
			T returnValue = front.getElement();
			front = front.getNext();
			if (front != null) {
				front.setPrev(null);
			}
			count --;
			return returnValue;
		}
	}

	public T first() throws EmptyCollectionException {
		// Complete this method.
		if (count == 0) {
			throw new EmptyCollectionException("");
		}
		return front.getElement();
	}

	public boolean isEmpty() {
		// Complete this method.
		return count == 0;
	}

	public int size() {
		// Complete this method.
		return count;
	}

	public String toString() {
		// Complete this method.
		return "";
	}
	
	public DoubleNode<T> getFront () {
		// Complete this method.
		return front;
	}
	
	public DoubleNode<T> getRear () {
		// Complete this method.
		return rear;
	}
	
}
