public class Polynomial {

    private Monomial term;

    public Polynomial() {

        OrderedLinkedList<Monomial> polynomial = new OrderedLinkedList<Monomial>(); // an ordered linked list of monomials
    }

    public void add (int coefficent, int degree) {

    }

    public Polynomial derivative() {
        return new Polynomial();
    }

    public double eval (double z) {
        return z;
    }

    public String toString () {
        String poop = "What";
        return poop;
    }
}
