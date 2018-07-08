package main.java.com.wiar.mathparser.operators;

public class DivisionOperator extends Operator {


    public DivisionOperator(int precedence, OperatorAssociativity associativity) {
        super(precedence, associativity);
    }

    public DivisionOperator() {
        this(Precedence.DIVISION, OperatorAssociativity.LEFT);
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
