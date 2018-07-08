package main.java.com.wiar.mathparser.operators;

public class SubtractionOperator extends Operator {


    public SubtractionOperator(int precedence, OperatorAssociativity associativity) {
        super(precedence, associativity);
    }

    public SubtractionOperator() {
        this(Precedence.SUBTRACTION, OperatorAssociativity.LEFT);
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
