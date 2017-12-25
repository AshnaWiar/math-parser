package main.java.com.wiar.mathparser;

import java.util.ArrayList;
import java.util.List;

import main.java.com.wiar.mathparser.operators.Operator;
import main.java.com.wiar.utils.OperatorAssociativity;

public class MathParser {
		
	public MathParser() {
		System.out.println("[MathParser] supported operators [+ , - * , /]\n");

	}

	public Double evaluateExpression(Expression e) {
		List<Double> nStack = new ArrayList<>(e.getNumberStack());
		List<Operator> oStack = new ArrayList<>(e.getOperatorStack());
		
				
		for(int i = 1; i < oStack.size(); i++) {
			Operator current = oStack.get(i);
			Operator stackHead = oStack.get(0);
			
			
			if(current.getPrecedence() <= stackHead.getPrecedence() && current.getAssociativity() == OperatorAssociativity.LEFT ){
				
				double i1 = nStack.get(i-1);
				double i2 = nStack.get(i);
				double i3 = stackHead.evaluate(i1, i2);
				
				nStack.set(i, i3);
				nStack.remove(i-1);
				oStack.remove(stackHead);
				stackHead = oStack.get(0);
				i--;
			
			}else {
				
				double i1 = nStack.get(i);
				double i2 = nStack.get(i+1);
				double i3 = current.evaluate(i1, i2);
				System.out.println(i3);
				nStack.set(i, i3);
				nStack.remove(i+1);
				oStack.remove(current);
				stackHead = oStack.get(0);
				i--;
			
			}if(oStack.size() == 1) {
			
				nStack.set(0, stackHead.evaluate(nStack.get(0), nStack.get(1)));
			}
			
		}
		return nStack.get(0);
	}
	
	public Function evaluateFunction(Function f) {
		return f;
	
	}

}