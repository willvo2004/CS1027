public class myOLLTest {
    public static void main(String[] args) {

        OrderedLinkedList<Integer> oll = new OrderedLinkedList<>();

        //int x = 1;
        //int y = 1;
        int x = (int) (Math.random()*100);
        int y = (int) (Math.random()*100);
        int[] all = new int[] {x,y};
        int first = 0;
        int second = 0;

        oll.insert(x); // insert the first number
        oll.insert(y); // order is not happening

        if (oll.getSize()!= 2) {
            System.out.println(false);
            System.out.println(oll.getSize());
        } else {
            first = oll.get(0);
            second = oll.get(1);
        }
        System.out.println(first);
        System.out.println(second);
        System.out.println(oll.getSize());
    }

    public static int test02() {
        OrderedLinkedList<Integer> oll = new OrderedLinkedList<>();
        int x = (int) (Math.random()*100);
        oll.insert(x);

        return oll.getSize();
    }

    public static boolean test04() {
        OrderedLinkedList<Integer> oll = new OrderedLinkedList<>();

        int x = (int) (Math.random()*100);
        int y = (int) (Math.random()*100);
        int[] all = new int[] {x,y};

        oll.insert(x);
        oll.insert(y);

        if (oll.getSize()!= 2) {
            return false;
        } else {
            int first = oll.get(0);
            int second = oll.get(1);

            return (first >= second) && (first == all[0] || first == all[1]) && (second == all[0] || second == all[1]);
        }

    }
}
