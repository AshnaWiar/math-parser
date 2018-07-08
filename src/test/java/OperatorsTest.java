package test.java;

import main.java.com.wiar.mathparser.operators.*;

import java.util.logging.Logger;

public class OperatorsTest {

    private static Logger logger = Logger.getLogger("Test:Operators");

    public static void main(String[] arg) {

        Operator addition = new AdditionOperator();
        Operator subtraction = new SubtractionOperator();
        Operator multiplication = new MultiplicationOperator();
        Operator division = new DivisionOperator();

        double result = addition.evaluate(5, 9);
        logger.info("result: 5 + 9 -> " + result);

        result = subtraction.evaluate(result, 2);
        logger.info("result: (5 + 9) - 2 -> " + result);

        result = multiplication.evaluate(result, 3);
        logger.info("result: ((5 + 9) - 2) * 2 -> " + result);

        result = division.evaluate(result, 8);
        logger.info("result: (((5 + 9) - 2) * 2 ) / 8 -> " + result);


    }

}
