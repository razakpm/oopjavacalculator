package com.cvtalks;

/**
 * @author yuriyganusyak
 * @version 0.0.2
 *
 * <p>String parser for calculator</p>
 * <p>Last update - 27 sep 2015</p>
 *
 * <p>Parses raw string, checks brace balance, and split a string to an array of operation strings
 * "sin(pi / 2)" -> ["sin", "(", "pi", "/", "2", ")"]
 * </p>
 * <p>v0.0.2 - regex based method operationStringsFromString(String)</p>
 *
 * <p>API:</p>
 * <p>public static boolean bracesBalanced(String)</p>
 * <p>public static boolean isNumericString(String)</p>
 */
public class OperatorParser {
    /**
     * <p>Checks braces balance in expression string</p>
     *
     * @param input string with math expression
     * @return true if string has right balance, otherwise - false
     */
    public static boolean bracesBalanced (String input) {
        int braceBalance = 0;

        for(char ch:input.toCharArray()){
            if (ch == '(') {
                braceBalance++;
            } else if (ch == ')') {
                braceBalance--;
            }
            if (braceBalance < 0) return false;
        }

        return (braceBalance == 0);
    }

    /** <p>Checks if input string represents a number</p>
     *
     * @param inputString - string to check like "1.02"
     * @return true if number, false if not
     */
    public static boolean isNumericString(String inputString) {
        return inputString.matches("[-+]?\\d*\\.?\\d+");
    }

    /** <p>Priority for math operations</p>
     *
     * @param operation operation string
     * @return 3 for "^", 2 for "*" and "/", 1 for "+" and "-"
     */
    public static int operationPriority(String operation) {
        switch (operation) {
            case "^": return 3;
            case "*": return 2;
            case "/": return 2;
            case "+": return 1;
            case "-": return 1;
            default: return 0;
        }
    }

    public static boolean isFunction(String operand) {
        return (operand.equals("sin") || operand.equals("cos") || operand.equals("sqrt") || operand.equals("sqr"));
    }

    /** <p>Checks if operation is binary</p>
     *
     * @param operationString operationString like "+"
     * @return true if operation is binary, otherwise - false
     */
    public static boolean isBinary(String operationString) {
        return (operationString.equals("+") || operationString.equals("-") || operationString.equals("*") || operationString.equals("/") || operationString.equals("^"));
    }

    /** <p>Checks if operation is unary</p>
     *
     * @param operationString operationString like "sqrt"
     * @return true if operation is unary, otherwise - false
     */
    public static boolean isUnary(String operationString) {
        return (operationString.equals("sqrt") || operationString.equals("sqr") || operationString.equals("sin") || operationString.equals("cos") || operationString.equals("tan"));
    }

    /** <p>Checks if operationString matches a math constant</p>
     *
     * @param operationString operationString like "pi"
     * @return true if operation is constant, otherwise - false
     */
    public static boolean isConstant (String operationString) {
        return (operationString.equals("pi") || operationString.equals("e"));
    }

    /** <p>Checks if operationString matches an arithmetic operator</p>
     *
     * @param operationString operationString like "+"
     * @return true if matches an arithmetic operator, otherwise - false
     */
    public static boolean isOperator(String operationString) {
        return (operationString.equals("+") || operationString.equals("-") || operationString.equals("*") || operationString.equals("/") || operationString.equals("^"));
    }

    /** <p>Checks if operationString matches parenthesis</p>
     *
     * @param operationString operationString like ")"
     * @return true if matches parenthesis, otherwise - false
     */
    public static boolean isParenthesis(String operationString) {
        return (operationString.equals("(") || operationString.equals(")"));
    }


    /** <p>Splits string to array with delimiters</p>
     * <p>last updated in v0.0.2</p>
     *
     * @param inputString raw input string for example "sin(pi / 2)"
     * @return array of operationStrings: ["sin", "(", "pi", "/", "2", ")"]
     * @throws IllegalArgumentException, when input has inbalanced braces
     *
     */
    public static String[] operationStringsFromString(String inputString) {
        if (!bracesBalanced(inputString)) throw new IllegalArgumentException("Expression has inbalanced braces");
        // Separates string by +, -, *, /, ^, (, ), and keeps delimiters in array (?=[*^(+-/)])|(?<=[*^(+-/)])
        String separator = "(?=[*^(+-/)])|(?<=[*^(+-/)])";
        // make a lowercase string
        inputString = inputString.toLowerCase();
        // remove all spaces
        inputString = inputString.replaceAll("\\s", "");
        return inputString.split(separator);
    }

    public static boolean isValidString(String inputString) {
        boolean result = true;
        if (!bracesBalanced(inputString)) return false;
        String separator = "(?=[*^(+-/)])|(?<=[*^(+-/)])";
        // make a lowercase string
        inputString = inputString.toLowerCase();
        // remove all spaces
        inputString = inputString.replaceAll("\\s", "");
        String[] array = inputString.split(separator);
        for (String operand : array) {
            if (!isNumericString(operand) && !isConstant(operand) && !isFunction(operand) && !isParenthesis(operand) && !isOperator(operand)) {
                return false;
            }
        }
        return true;
    }
}
