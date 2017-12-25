package main.java.com.wiar.mathparser.operators;

import main.java.com.wiar.utils.OperatorAssociativity;
import main.java.com.wiar.utils.Precedence;

public abstract class Operator {
	
	private OperatorAssociativity associativity;
	private int precedence;

	public Operator(int adition, OperatorAssociativity associativity) {
		this.precedence = adition;
		this.associativity = associativity;
	}
	
	public int getPrecedence() {
		return this.precedence;
	}

	public OperatorAssociativity getAssociativity() {
		return associativity;
	}

	public static Operator get(String s) {
		switch(s) {
		case "+":
			return new AdditionOperator();
		case "-":
			return new SubtractionOperator();
		case "/":
			return new DivisionOperator();
		case "*":
			return new MultiplicationOperator();
		}
		return null;
	}
	
	
	public String toString() {
		return String.valueOf(getSymbol());
	}
	
	
	public abstract double evaluate(double i1, double i2);
	
	public abstract char getSymbol();
	
}