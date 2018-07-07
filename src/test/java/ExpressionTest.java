package test.java;

import main.java.com.wiar.mathparser.Expression;

import java.util.Arrays;

public class ExpressionTest {

    public static void main(String[] arg) {

        Expression ex = new Expression("22*3/9-9");

        System.out.println(ex.getExpression());
        System.out.println(Arrays.toString(ex.getNumberList().toArray()));
        System.out.println(Arrays.toString(ex.getOperatorList().toArray()));


    }
}
