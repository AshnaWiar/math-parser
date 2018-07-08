package main.java.com.wiar.mathparser.operators;

public abstract class Operator {

    private OperatorAssociativity associativity;
    private int precedence;

    public Operator(int precedence, OperatorAssociativity associativity) {
        this.precedence = precedence;
        this.associativity = associativity;
    }

    public static Operator get(String s) {
        switch (s) {
            case "+":
                return new AdditionOperator();
            case "-":
                return new SubtractionOperator();
            case "/":
                return new DivisionOperator();
            case "*":
                return new MultiplicationOperator();
            case "(":
                return new ParenthesesOperator(true);
            case ")":
                return new ParenthesesOperator(false);
            default:
                throw new IllegalArgumentException("invalid Argument [" + s + "] is not an operator.");
        }

    }

    public static boolean isOperator(String s) {
        try {
            get(s);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public int getPrecedence() {
        return this.precedence;
    }

    public OperatorAssociativity getAssociativity() {
        return associativity;
    }

    public String toString() {
        return String.valueOf(getSymbol());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Operator))
            return false;
        Operator target = (Operator) obj;

        return getSymbol() == target.getSymbol();
    }

    public abstract double evaluate(double i1, double i2);

    public abstract char getSymbol();

}