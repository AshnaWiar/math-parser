package main.java.com.wiar.mathparser;

import main.java.com.wiar.mathparser.operators.Operator;
import main.java.com.wiar.utils.Utils;

import java.util.List;

public class Expression {

    @Deprecated
    private List<Double> numberList;
    @Deprecated
    private List<Operator> operatorList;

    private List<Object> expression;

    public Expression(String e) {
        this.expression = Utils.parseExpression(e);
        this.numberList = Utils.getNumbers(e);
        this.operatorList = Utils.getOperators(e);
    }


    @Deprecated
    public List<Double> getNumberList() {
        return numberList;
    }

    @Deprecated
    public List<Operator> getOperatorList() {
        return operatorList;
    }

    public List<Object> getExpression() {
        return expression;
    }

    public String toString() {
        return Utils.ListToString(expression);
    }
}
