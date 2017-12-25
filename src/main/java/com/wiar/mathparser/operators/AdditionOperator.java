package main.java.com.wiar.mathparser.operators;

import main.java.com.wiar.utils.OperatorAssociativity;
import main.java.com.wiar.utils.Precedence;

public class AdditionOperator extends Operator{
	
	public AdditionOperator(int precedence, OperatorAssociativity associativity) {
		super(precedence, associativity);
	}
		
	public AdditionOperator() {
		this(Precedence.ADDITION, OperatorAssociativity.LEFT);
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
