package main.java.com.wiar.mathparser.operators;

public final class DivisionOperator extends Operator {

    private static DivisionOperator instance;

    public DivisionOperator() {
        super(Precedence.DIVISION, OperatorAssociativity.LEFT);
    }

    public static Operator getInstance(){
        if(instance == null)
            instance = new DivisionOperator();
        return instance;
    }

    @Override
    public double evaluate(double i1, double i2) {
        return i1 / i2;
    }

    @Override
    public char getSymbol() {
        return '/';
    }

}
