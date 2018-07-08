package main.java.com.wiar.mathparser.operators;

public final class MultiplicationOperator extends Operator {

    private static MultiplicationOperator instance;

    public MultiplicationOperator() {
        super(Precedence.MULTIPLICATION, OperatorAssociativity.LEFT);
    }

    public static Operator getInstance(){
        if(instance == null)
            instance = new MultiplicationOperator();
        return instance;
    }

    @Override
    public double evaluate(double i1, double i2) {
        return i1 * i2;
    }

    @Override
    public char getSymbol() {
        return '*';
    }

}
