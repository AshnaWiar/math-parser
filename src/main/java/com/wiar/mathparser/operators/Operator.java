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
                return AdditionOperator.getInstance();
            case "-":
                return SubtractionOperator.getInstance();
            case "/":
                return DivisionOperator.getInstance();
            case "*":
                return MultiplicationOperator.getInstance();
            case "(":
                return OpenParenthesesOperator.getInstance();
            case ")":
                return CloseParenthesesOperator.getInstance();
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
        if (obj instanceof Operator) {
            Operator target = (Operator) obj;
            return getSymbol() == target.getSymbol();
        }else if(obj instanceof String){
            String symbol = (String) obj;
            return symbol.equals(String.valueOf(getSymbol()));
        }
        return false;
    }

    public abstract double evaluate(double i1, double i2);

    public abstract char getSymbol();

}