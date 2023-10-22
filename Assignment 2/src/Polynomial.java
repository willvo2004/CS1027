public class Polynomial {

    private OrderedLinkedList<Monomial> expression;

    public Polynomial() {
        expression = new OrderedLinkedList<Monomial>();
    }

    public void add (int coefficient, int degree) {
        Monomial term = new Monomial(coefficient, degree);
        expression.insert(term);
    }

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

    public double eval (double z) {
        double expressionAtZ = 0;

        for (int i = 0; i < expression.getSize(); i ++) {

            Monomial evaluatedTerm = expression.get(i);
            double termValueAtZ = evaluatedTerm.getCoefficient() * Math.pow(z, evaluatedTerm.getDegree());
            // prolly will break for constant terms
            expressionAtZ += termValueAtZ;
        }
        return expressionAtZ;
    }

    public String toString () {
        if (expression.getSize() == 0) {
            return "";
        }
        String poop = "What";
        return poop;
    }

    public double solve (double x0, double e, int T) throws SolutionNotFound {
        // when the absolute value opf the difference between two different successive approximations
        // of the root is less than e, then Newton's method stops and a solution is found.
        // If the number of iterations exceeds T, then the method is not successful.
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
        if (counter > T) {
            throw new SolutionNotFound("maximum iteration exceeded");
        } else {
            return current;
        }

    }
}
