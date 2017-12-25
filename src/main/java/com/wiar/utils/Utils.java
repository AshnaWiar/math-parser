package main.java.com.wiar.utils;

import java.util.ArrayList;
import java.util.List;

import main.java.com.wiar.mathparser.operators.Operator;

public final class Utils {
	
	public static Double toDouble(String s) {
		return Double.parseDouble(s);
	}
	
	public static double[] toDouble(String[] s) {
		double[] tmpList = new double[s.length];
		
		for(int i = 0; i < s.length; i++) {
			tmpList[i] = toDouble(s[i]);
		}
		return tmpList;
	}
	
	public static int toInt(String s) {
		return Integer.parseInt(s);
	}

	public static boolean isInteger(String c) {
		try {
			Integer.parseInt(c);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}

	public static List<Double> getNumbers(String e) {
		String[] _numbers = e.replaceAll("\\s", "").replaceAll("\\+", " ").replaceAll("\\*", " ").replaceAll("/", " ").replaceAll("-", " ").split(" ");
		
		List<Double> numbers = new ArrayList<>();
		
		for(String s : _numbers) 
			numbers.add( toDouble(s));
		
		return numbers;
	}

	public static List<Operator> getOperators(String e) {
		String[] list = e.replaceAll("//s", "").split("");
		List<Operator> op = new ArrayList<>();
		
		for(String s : list) {
			if(isInteger(s) || s.equals("."))
				continue;
			
			op.add(Operator.get(s));
		}
		
		return op;
	}

	public static boolean isInteger(char c) {
		try {
			Integer.parseInt(c+"");
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}

	public static String formatExpression(String e) {
		return e.replaceAll("\\s", "").replaceAll("\\+", " + ").replaceAll("\\*", " * ").replaceAll("/", " / ").replaceAll("-", " - ");
	}
}
