public class ArrayStack<T> implements StackADT<T> {

    private T[] array;
    private int top;

    public ArrayStack() {
        this.array =  (T[]) (new Object[10]);
        this.top = -1;
    }

    public void push (T element) {
        if (top >= (array.length * 0.75)) {
            expandCapacity();
        }
        array[top] = element;
        top ++;
    }

    public T pop() throws StackException {
        if (top == -1) {
            throw new StackException("Stack is Empty");
        }
    }

    public T peek() throws StackException {
        if (top == -1) {
            throw new StackException("Stack is Empty");
        }
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        int counter = 0;
        while (top != -1) {
            top --;
            counter++;
        }
        return counter;
    }

    public void clear() {
        T[] newArray = (T[]) (new Object[10]);
        array = newArray;
        top = -1;
    }

    public int getCapacity() {
        return array.length;
    }

    public int getTop() {
        return top;
    }

    public String toString() {
        if (top == -1) {
            return "Empty Stack.";
        }
        // do some some shinanenges with the thing with a loop and then return it with some question marks
    }

    private void expandCapacity() {
        int newSize = array.length + 10;
        T[] newArray = (T[]) (new Object[newSize]);

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

}
