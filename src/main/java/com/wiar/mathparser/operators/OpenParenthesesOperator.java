package main.java.com.wiar.mathparser.operators;

public final class OpenParenthesesOperator extends ParenthesesOperator {

    private static OpenParenthesesOperator instance;

    public OpenParenthesesOperator() {
        super(true);

    }

    public static Operator getInstance(){
        if(instance == null)
            instance = new OpenParenthesesOperator();
        return instance;
    }
}
