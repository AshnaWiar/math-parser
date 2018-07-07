package test.java;

import main.java.com.wiar.mathparser.Expression;
import main.java.com.wiar.mathparser.MathParser;
import main.java.com.wiar.mathparser.algorithm.Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class ExpressionEvaluationTest {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //96+85/96*85+96*85/85-85*96/85*96+63 bug, wrong answer
        System.out.print("Type your expression: ");
        testExpression(s.nextLine());
    }

    static void testExpression(String expression) {
        MathParser mp = new MathParser(Algorithm.REVERSE_POLISH_NOTATION);
        Expression ex = new Expression(expression);

        double result = mp.evaluate(ex);
        System.out.println("1: " + Arrays.toString(ex.getNumberList().toArray()));
        System.out.println("2: " + Arrays.toString(ex.getOperatorList().toArray()));
        System.out.println("3: " + ex);
        System.out.println("4: " + ex + " = " + result);

    }

}
