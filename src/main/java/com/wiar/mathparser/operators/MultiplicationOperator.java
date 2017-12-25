package main.java.com.wiar.mathparser.operators;

import main.java.com.wiar.utils.OperatorAssociativity;
import main.java.com.wiar.utils.Precedence;

public class MultiplicationOperator extends Operator {

	public MultiplicationOperator(int precedence, OperatorAssociativity associativity) {
		super(precedence, associativity);
	}
	
	public MultiplicationOperator() {
		this(Precedence.MULTIPLICATION, OperatorAssociativity.LEFT);
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
