public class myOLLTest {
    public static void main(String[] args) {

        Polynomial p = new Polynomial();

        p.add(-1,1);
        p.add(3,3);
        p.add(-2,2);

        String out = p.toString();

        System.out.println(out);
    }

}
