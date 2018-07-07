package main.java.com.wiar.utils;

import main.java.com.wiar.mathparser.exceptions.MathError;
import main.java.com.wiar.mathparser.operators.Operator;

import java.util.ArrayList;
import java.util.List;

public final class Utils {

    public static double toDouble(String s) {
        return Double.parseDouble(s);
    }

    public static int toInt(String s) {
        return Integer.parseInt(s);
    }

    public static boolean isNumber(String c) {
        try {
            Integer.parseInt(c);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Deprecated
    public static List<Double> getNumbers(String e) {
        String[] _numbers = e.
                replaceAll("\\s", "").
                replaceAll("\\(", "").
                replaceAll("\\)", "").
                replaceAll("\\+", " ").
                replaceAll("\\*", " ").
                replaceAll("/", " ").
                replaceAll("-", " ").
                split(" ");

        List<Double> numbers = new ArrayList<>();

        for (String s : _numbers)
            numbers.add(toDouble(s));

        return numbers;
    }

    @Deprecated
    public static List<Operator> getOperators(String e) {
        String[] list = e.replaceAll("//s", "").split("");
        List<Operator> op = new ArrayList<>();

        for (String s : list) {
            if (isNumber(s) || s.equals("."))
                continue;

            op.add(Operator.get(s));
        }

        return op;
    }

    public static String ListToString(List l) {
        return l.toString().
                replace("[", "").
                replace("]", "").
                replace(",", "");
    }

    // Messy!
    public static List<Object> parseExpression(String e) {
        List<Object> expression = new ArrayList<>();
        char[] list = e.replaceAll("\\s", "").toCharArray();
        for (int i = 0; i < list.length; ) {
            String val = String.valueOf(list[i]);

            // val is number
            if (isNumber(val)) {

                //save it
                StringBuilder number = new StringBuilder(val);
                //check if the next char is a number.
                if (i < list.length - 1) { // boolean possible to get next value?
                    int counterVal = i + 1;
                    String valNext = String.valueOf(list[counterVal]); // get nextValue
                    while (isNumber(valNext) || valNext.equals(".")) { // number, dot check.
                        number.append(valNext);
                        counterVal++;
                        if (counterVal == list.length)
                            break;
                        else
                            valNext = String.valueOf(list[counterVal]);
                    }
                    i = counterVal;
                    expression.add(toDouble(number.toString())); // convert number to double and add
                } else { // add and continue
                    expression.add(toDouble(number.toString()));// convert number to double and add
                    i++;
                }
            } else if (Operator.isOperator(val)) {
                expression.add(Operator.get(val));
                i++;
            } else
                throw new MathError("Invalid syntax: '" + val + "' at index " + e.indexOf(val) + " of '" + e + "'.");
        }
        return expression;
    }
}
