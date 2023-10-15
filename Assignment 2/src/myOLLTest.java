public class myOLLTest {
    public static void main(String[] args) {
        System.out.println(test02());
    }

    public static int test02() {
        OrderedLinkedList<Integer> oll = new OrderedLinkedList<>();
        int x = (int) (Math.random()*100);
        oll.insert(x);

        return oll.getSize();
    }
}
