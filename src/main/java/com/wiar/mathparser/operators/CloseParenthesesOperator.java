package main.java.com.wiar.mathparser.operators;

public final class CloseParenthesesOperator extends ParenthesesOperator {

    private static CloseParenthesesOperator instance;

    public CloseParenthesesOperator() {
        super(false);
    }

    public static Operator getInstance(){
        if(instance == null)
            instance = new CloseParenthesesOperator();
        return instance;
    }
}
