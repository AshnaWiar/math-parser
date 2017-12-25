package test.java;

import java.util.Arrays;

import main.java.com.wiar.mathparser.Expression;
import main.java.com.wiar.mathparser.MathParser;

public class ExpressionEvaluationTest {

	public static void main(String[] args) {
		MathParser mp = new MathParser();
		Expression ex = new Expression("22*3/9-9");
		
		double result = mp.evaluateExpression(ex);
		
		System.out.println("1: " + Arrays.toString(ex.getNumberStack().toArray()));
		System.out.println("2: " + Arrays.toString(ex.getOperatorStack().toArray()));
		
		System.out.println("3: " + ex);
		System.out.println("4: " + ex.getExpression() + " = " + result);
		
	}

}
