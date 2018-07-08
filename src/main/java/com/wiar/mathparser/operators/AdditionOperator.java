package main.java.com.wiar.mathparser.operators;

public final class AdditionOperator extends Operator {

    private static AdditionOperator instance;

    public AdditionOperator() {
        super(Precedence.ADDITION, OperatorAssociativity.LEFT);
    }

    public static Operator getInstance(){
        if(instance == null)
            instance = new AdditionOperator();
        return instance;
    }

    @Override
    public double evaluate(double i1, double i2) {
        return i1 + i2;
    }

    @Override
    public char getSymbol() {
        return '+';
    }

}
