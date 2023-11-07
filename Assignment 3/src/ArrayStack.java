public class ArrayStack<T> implements StackADT<T> {

    private T[] array;
    private int top;

    public ArrayStack() {
        this.array =  (T[]) (new Object[10]);
        this.top = -1;
    }

    public void push (T element) {
        if (top + 1 >= (array.length * 0.75)) {
            expandCapacity();
        } if (top == -1) {
            array[0] = element;
            top = 0;
        }
        else {
            array[top + 1] = element;
            top ++;
        }
    }

    public T pop() throws StackException {
        if (top == -1) {
            throw new StackException("Stack is empty");
        }
        else if (top + 1 <=(array.length * 0.25) && array.length >= 20) {
            shrinkCapacity();
        }
        T element = array[top];
        array[top] = null;
        top--;
        return element;
    }

    public T peek() throws StackException {
        if (top == -1) {
            throw new StackException("Stack is empty");
        }
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        int counter = 0;
        while (counter != top + 1) {
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
            return "Empty stack.";
        }
        String stack = "Stack: ";
        for (int i = top ; i >= 0; i--) {
            if (i == 0) {
                stack += array[i] + ".";
            } else {
               // if (array[i] != null) {
                    stack += array[i] + ", ";
                //}
            }
        }
        return stack;

    }

    private void expandCapacity() {
        int newSize = array.length + 10;
        T[] newArray = (T[]) new Object[newSize];

        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    private void shrinkCapacity() {
        int newSize = array.length - 10;
        T[] newArray = (T[]) new Object[newSize];

        System.arraycopy(array, 0, newArray, 0, newArray.length);
        array = newArray;
    }


}
