/**
 * Represents a mathematical polynomial. The polynomial is composed of monomials, and
 * operations can be performed on it such as differentiation and evaluation at a given point.
 * This class has only one private field, and has six public methods.
 */
public class Polynomial {

    /** The ordered list of monomials representing a polynomial. */
    private final OrderedLinkedList<Monomial> expression;

    /**
     * Constructs an empty Polynomial.
     */
    public Polynomial() {
        expression = new OrderedLinkedList<>();
    }

    /**
     * Adds a monomial to the polynomial with a given coefficient and degree.
     * @param coefficient the coefficient of the monomial
     * @param degree the degree of the monomial
     */
    public void add (int coefficient, int degree) {
        Monomial term = new Monomial(coefficient, degree);
        expression.insert(term);
    }

    /**
     * Computes and returns the derivative of this polynomial.
     * It skips adding a term if its coefficient is equal to zero.
     * @return the derived polynomial
     */
    public Polynomial derivative() {
        Polynomial derivedExpression = new Polynomial();

        for (int i = 0; i < expression.getSize(); i ++) {

            Monomial derivedTerm = expression.get(i);
            int coefficient = derivedTerm.getCoefficient() * derivedTerm.getDegree();
            int degree = derivedTerm.getDegree() - 1;

            if (coefficient != 0) {
                derivedExpression.add(coefficient, degree);
            }
        }
        return derivedExpression;
    }

    /**
     * Evaluates the polynomial at a given point z.
     * @param z the point of evaluation
     * @return the value of the polynomial at z
     */
    public double eval (double z) {
        double expressionAtZ = 0;
        double termValueAtZ;

        for (int i = 0; i < expression.getSize(); i ++) {

            Monomial evaluatedTerm = expression.get(i);

            if (evaluatedTerm.getDegree() != 0) {
                termValueAtZ = evaluatedTerm.getCoefficient() * Math.pow(z, evaluatedTerm.getDegree());
            } else {
                termValueAtZ = evaluatedTerm.getCoefficient();
            }

            expressionAtZ += termValueAtZ;
        }
        return expressionAtZ;
    }

    /**
     * Converts the polynomial to a string representation.
     * @return the string representation of the polynomial
     */
    public String toString () {
        if (expression.getSize() == 0) {
            return "";
        }
        String polynomial = "";

        for (int i = 0; i < expression.getSize(); i ++) {
            Monomial term = expression.get(i);

            if (i == 0) {
                polynomial += term.getCoefficient() + "*x^" + term.getDegree();
            }
            else if (i != expression.getSize() - 1) {
                polynomial += ((term.getCoefficient() > 0) ? " + ": " - ") + Math.abs(term.getCoefficient()) + "*x^" + term.getDegree();
            }
            else {
                polynomial += ((term.getCoefficient() > 0) ? " + ": " - ") + Math.abs(term.getCoefficient()) + "*x^" + term.getDegree();
            }
        }
        return polynomial;
    }

/**
 * Attempts to find a root of the polynomial using the Newton method starting from an initial guess x0.
 * The process continues until either the maximum number of iterations T is reached or the absolute difference
 * between consecutive approximations is less than e.
 * Throws SolutionNotFound if the maximum number of iterations T is reached or the absolute difference
 * between consecutive approximations is less than e.
 * @param x0 initial guess that is used in the first iteration of Newton's method
 * @param e  represents the tolerance of the solution
 * @param T represents the maximum number of iterations that Newton’s method runs for
 * @return a double, representing the root of the polynomial
 * @throws SolutionNotFound if the derivative at some value is equal to zero
 *                          if the total number of iterations exceeds the value of T
 */
    public double solve (double x0, double e, int T) throws SolutionNotFound {
        double previous = x0;
        double current;
        Polynomial derivedExpression = this.derivative();

        if (derivedExpression.eval(previous) != 0) {
            current = previous - (this.eval(previous) / derivedExpression.eval(previous));
        } else {
            throw new SolutionNotFound("divide by zero error");
        }

        int counter = 0;

        while (counter < T && Math.abs(current - previous) > e) {
            previous = current;
            if (derivedExpression.eval(previous) != 0) {
                current = previous - (this.eval(previous) / derivedExpression.eval(previous));
            } else {
                throw new SolutionNotFound("divide by zero error");
            }
            counter ++;
        }

        if (counter >= T) {
            throw new SolutionNotFound("maximum iteration exceeded");
        } else {
            return current;
        }

    }
}
