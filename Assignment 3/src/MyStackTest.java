public class MyStackTest {

    public static void main(String[] args) {

        ArrayStack<String> sStack = new ArrayStack<String>();
        ArrayStack<Integer> iStack = new ArrayStack<Integer>();

        for (int i = 50; i <= 65; i++) {
            iStack.push(i);
        }

        for (int i = 15; i < 50; i++) {
            iStack.push(i);
        }
        for (int i = 0; i < 15; i++) {
            iStack.push(i);
        }

       /** for (int i = 0; i < 45; i++) {
            iStack.pop();
        } */

        System.out.println(iStack.getCapacity());
    }
}
