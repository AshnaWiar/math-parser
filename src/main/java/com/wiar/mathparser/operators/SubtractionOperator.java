package main.java.com.wiar.mathparser.operators;

public final class SubtractionOperator extends Operator {

    private static SubtractionOperator instance;

    public SubtractionOperator() {
        super(Precedence.SUBTRACTION, OperatorAssociativity.LEFT);
    }

    public static Operator getInstance(){
        if(instance == null)
            instance = new SubtractionOperator();
        return instance;
    }

    @Override
    public double evaluate(double i1, double i2) {
        return i1 - i2;
    }

    @Override
    public char getSymbol() {
        return '-';
    }

}
