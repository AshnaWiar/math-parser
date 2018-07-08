package main.java.com.wiar.mathparser.algorithm;

import main.java.com.wiar.mathparser.Expression;
import main.java.com.wiar.mathparser.algorithm.impl.IAlgorithm;
import main.java.com.wiar.mathparser.operators.Operator;
import main.java.com.wiar.mathparser.operators.OperatorAssociativity;
import main.java.com.wiar.mathparser.operators.ParenthesesOperator;
import main.java.com.wiar.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ShuntingYardAlgorithm implements IAlgorithm {

    private List<Object> generateReversePolishNotation(Expression expression) {
        List<Object> tokens = expression.getExpression();
        List<Object> output = new ArrayList<>();
        List<Operator> operatorStack = new ArrayList<>();
        for (Object token : tokens) {

            if (isOperator(token)) {
                Operator operator = (Operator) token;
                /*
                while ((there is a function at the top of the operator stack)
                   or (there is an operator at the top of the operator stack with greater precedence)
                   or (the operator at the top of the operator stack has equal precedence and is left associative))
                   and (the operator at the top of the operator stack is not a left bracket):
                 */
                while (operatorStack.size() != 0 &&
                        !isParentheses(operator) &&
                        operatorStack.get(0).getPrecedence() >= operator.getPrecedence() &&
                        operatorStack.get(0).getAssociativity() == OperatorAssociativity.LEFT
                        )
                {
                    pop(operatorStack, output);
                }
                operatorStack.add(0, operator);


                if (operator instanceof ParenthesesOperator) {
                    ParenthesesOperator parentheses = (ParenthesesOperator) operator;

                    if (!parentheses.isOpen()) {
                        operatorStack.remove(0);

                        while (!operatorStack.get(0).equals("(")) {
                            pop(operatorStack, output);
                        }

                        if (operatorStack.get(0) instanceof ParenthesesOperator
                                && operatorStack.get(0).equals("(")) {
                            operatorStack.remove(0);
                        }
                    }
                }
                continue;
            }
            output.add(token);

        }
        output.addAll(operatorStack);
        return output;
    }

    private void pop(List<Operator> operatorStack, List<Object> stack) {
        pop(operatorStack.get(0), stack);
        operatorStack.remove(0);
    }

    private void pop(Operator operator, List<Object> stack) {
        pop(operator, stack, stack.size() - 1);
    }

    private void pop(Operator operator, List<Object> stack, int index) {
        // check 1
        if (stack.size() <= index)
            throw new ArrayIndexOutOfBoundsException();

        // check 2
        if (!(stack.get(index) instanceof Number) || !(stack.get(index - 1) instanceof Number))
            throw new IllegalArgumentException("Expected doubles got: " +
                    stack.get(index) + ", " +
                    stack.get(index - 1) + ", " +
                    stack.toString());

        //save to cast double
        double prevToken = (double) stack.get(index - 1); // [5] + 2 <- prev one
        double currentToken = (double) stack.get(index); // 5 + [2] <- current one
        currentToken = operator.evaluate(prevToken, currentToken);

        // remove the current index
        stack.remove(index);
        // update pev value to currentToken.
        stack.set(index - 1, currentToken);
    }

    private boolean isOperator(Object object) {
        return (object instanceof Operator);
    }

    private boolean isParentheses(Object object) {
        return (object instanceof ParenthesesOperator);
    }

    @Override
    public double evaluate(Expression expression) {
        List<Object> postfix = generateReversePolishNotation(expression);
        System.out.println("Debug RPN: " + StringUtils.formatListSimple(postfix));
        return popAll(postfix);
    }

    private double popAll(List<Object> postfix) {
        if (postfix.size() == 0)
            throw new IllegalArgumentException("Invalid argument, got array of size 0");

        List<Object> output = new ArrayList<>();
        for (Object indexVal : postfix) {
            if (indexVal instanceof Number) {
                output.add(indexVal);
                continue;
            }

            pop((Operator) indexVal, output);
        }

        if (output.size() == 0)
            throw new RuntimeException("unable to execute the RPN '" + StringUtils.formatListSimple(postfix) + "'.");

        return (double) output.get(0);
    }
}