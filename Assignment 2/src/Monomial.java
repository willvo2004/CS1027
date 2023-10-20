public class Monomial implements Comparable<Monomial> {

    private int coefficient;
    private int degree;

    public Monomial(int coefficient, int degree) {
        this.coefficient = coefficient;
        this.degree = degree;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public int getDegree() {
        return degree;
    }

    @Override
    public int compareTo(Monomial m) {
        return this.degree - m.degree; // order by degree.
        // return > 0 if this.degree is bigger, return < 0 if m.degree is bigger
    }
}
