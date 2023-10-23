public class myOLLTest {
    public static void main(String[] args) {

        Polynomial p = new Polynomial();

        p.add(6,0);
        p.add(10,10);
        p.add(-5,5);
        p.add(3,3);
        p.add(1,1);

        String out = p.toString();

        System.out.println(out);
    }

}
