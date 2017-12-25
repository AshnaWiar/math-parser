package test.java;

import java.util.Arrays;

import main.java.com.wiar.mathparser.Expression;

public class ExpressionTest {

	public static void main(String[] arg) {
		
		Expression ex = new Expression("22*3/9-9");
		
		System.out.println(ex.getExpression());
		System.out.println(Arrays.toString(ex.getNumberStack().toArray()));
		System.out.println(Arrays.toString(ex.getOperatorStack().toArray()));

		
	}
}
