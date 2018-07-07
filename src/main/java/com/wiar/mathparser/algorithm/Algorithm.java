package main.java.com.wiar.mathparser.algorithm;

import main.java.com.wiar.mathparser.Expression;
import main.java.com.wiar.mathparser.algorithm.impl.IAlgorithm;

public enum Algorithm {

    // https://en.wikipedia.org/wiki/Edsger_W._Dijkstra
    REVERSE_POLISH_NOTATION(new ShuntingYardAlgorithm());

    private IAlgorithm algorithm;

    Algorithm(IAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public Double evaluate(Expression e) {
        return this.algorithm.evaluate(e);
    }
}
