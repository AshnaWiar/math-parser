package main.java.com.wiar.mathparser;

import java.util.List;

import main.java.com.wiar.mathparser.operators.Operator;
import main.java.com.wiar.utils.Utils;

public class Expression {
	
	private List<Double> numberStack;
	private List<Operator> operatorStack;
	
	private String expression;
	
	public Expression(String e) {
		this.expression = Utils.formatExpression(e);
		this.numberStack = Utils.getNumbers(e);
		this.operatorStack = Utils.getOperators(e);
	}
	
	public List<Double> getNumberStack() {
		return numberStack;
	}

	public List<Operator> getOperatorStack() {
		return operatorStack;
	}

	public String getExpression() {
		return expression;
	}
	
	public String toString() {
		return expression + " = y";
	}
}
