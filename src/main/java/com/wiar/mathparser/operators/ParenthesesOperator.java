package main.java.com.wiar.mathparser.operators;

public class ParenthesesOperator extends Operator {

    private final boolean open;

    public ParenthesesOperator(boolean isOpen) {
        super(0, null);
        this.open = isOpen;
    }

    public boolean isOpen() {
        return open;
    }

    @Override
    public double evaluate(double i1, double i2) {
        throw new RuntimeException("Cannot evaluate parentheses");
    }

    @Override
    public char getSymbol() {
        if (isOpen())
            return '(';
        else
            return ')';
    }
}
