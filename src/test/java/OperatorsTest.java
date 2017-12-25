package test.java;

import main.java.com.wiar.mathparser.operators.AdditionOperator;
import main.java.com.wiar.mathparser.operators.DivisionOperator;
import main.java.com.wiar.mathparser.operators.MultiplicationOperator;
import main.java.com.wiar.mathparser.operators.Operator;
import main.java.com.wiar.mathparser.operators.SubtractionOperator;

public class OperatorsTest {
	
	public static void main(String[] arg) {
		Operator addition = new AdditionOperator();
		Operator substraction = new SubtractionOperator();
		Operator multiplication = new MultiplicationOperator();
		Operator division	= new DivisionOperator();
		
		double result = addition.evaluate(5, 9);
		result = substraction.evaluate(result, 2);
		result = multiplication.evaluate(result, 3);
		result = division.evaluate(result, 8);
		
		System.out.println( result );
		
	}

}
