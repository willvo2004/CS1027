/**
 * Represents a mathematical monomial with an integer coefficient and degree. It has two private fields, and four public methods.
 * This class implements the Comparable interface to allow for comparison based on the degree of monomials.
 */
public class Monomial implements Comparable<Monomial> {

    /** The coefficient of the monomial. */
    private final int coefficient;

    /** The degree of the monomial. */
    private final int degree;

    /**
     * Constructs a Monomial with a specified coefficient and degree.
     * @param coefficient the coefficient of the monomial
     * @param degree the degree of the monomial
     */
    public Monomial(int coefficient, int degree) {
        this.coefficient = coefficient;
        this.degree = degree;
    }

    /**
     * Returns the coefficient of the monomial.
     * @return the coefficient of the monomial
     */
    public int getCoefficient() {
        return coefficient;
    }

    /**
     * Returns the degree of the monomial.
     * @return the degree of the monomial
     */
    public int getDegree() {
        return degree;
    }


    /**
     * Compares this monomial to another based on their degrees.
     * @param m the monomial to compare to
     * @return a positive integer if this monomial's degree is greater,
     *         a negative integer if it's lesser, and 0 if they are equal
     */
    @Override
    public int compareTo(Monomial m) {
        return this.degree - m.degree; // order by degree.
        // return > 0 if this.degree is bigger, return < 0 if m.degree is bigger
    }
}
