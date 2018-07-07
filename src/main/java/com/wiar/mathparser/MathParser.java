package main.java.com.wiar.mathparser;

import main.java.com.wiar.mathparser.algorithm.Algorithm;

public class MathParser {
    public static final String VERSION = "1.0";
    private final Algorithm algorithm;

    public MathParser() {
        this(Algorithm.REVERSE_POLISH_NOTATION);

    }

    public MathParser(Algorithm algorithm) {
        this.algorithm = algorithm;
        System.out.println("[MathParser] version: "+ VERSION +"\nsupported operators [ +, -, *, /, (, ) ]\n");
    }

    public Double evaluate(Expression e) {
        return this.algorithm.evaluate(e);
    }

    public Function evaluate(Function f) {
        return f;

    }

}
