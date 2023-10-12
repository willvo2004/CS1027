public class ReversibleArray<T> {

    private T[] array;
    private int count;

    public ReversibleArray(T[] array) {
        this.array = array;
        count = array.length;
    }

    public String toString() {
        String values = "";
        for (int i = 0; i < count; i++) {
            values += array[i] + ", ";
            if (i == count - 1) {
                values += array[i];
            }
        }
        return values.strip();
    }

    public void reverse () {
        int left = 0; // define index pointers
        int right = count - 1;

        while (left < right) {
            T tempValue = array[left]; // store the value that gets swapped
            array[left] = array[right];
            array[right] = tempValue;

            left ++; // update pointer values
            right --;
        }
    }
}
