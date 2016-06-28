package com.cvtalks;

import java.util.Stack;

/**
 * @author yuriy.ganusyak
 * @version 0.0.1
 *          <p>This class calculates a value of string expression</p>
 *          <p>last update: 27 sep 2015</p>
 *          <p>Example input
 *          "sin(pi/2)"
 *          API:
 *          public static Double calculate(String) - returns a double value of given expression (for correct input) or
 *          throws exceptions
 *          public static Operation getOperation(String) - returns an instance of Operation for given string input
 *          public static String getPRNString(String) - returns PRN string for given input
 *          </p>
 *          <p>cases to Fix: cos*sin(0);</p>
 */
public class PRNCalculator {

    /**
     * <p>Returns a resulting value for given expression</p>
     *
     * @param input Input string with math expression like "3 + 2"
     * @return double value of result: 5.0 for given input
     */

    public static Double calculate(String input) {
        return finalOperation(polishReverseOrderedArrayOfOperationStringsFrom(input)).evaluate();
    }

    /**
     * <p>Returns an instance on Operation class for given expression</p>
     *
     * @param input Input string with math expression like "3 + 2"
     * @return instance of Operation ready to evaluate()
     */

    public static Operation getOperation(String input) {
        return finalOperation(polishReverseOrderedArrayOfOperationStringsFrom(input));
    }

    /**
     * <p>Returns a polish reverse notation string for given math expression</p>
     *
     * @param input Input string with math expression like "3 + 2"
     * @return Output string in PRN format: "3 2 +"
     */

    public static String getPRNString(String input) {
        String result = "";
        String[] operationStrings = polishReverseOrderedArrayOfOperationStringsFrom(input);
        for (int i = 0; i < operationStrings.length; i++) {
            result += operationStrings[i];
            if (i < operationStrings.length - 1) {
                result += " ";
            }
        }
        return result;
    }

    /**
     * <p>Returns a binary operation for given operationString(identifier), and two operands</p>
     *
     * @param operationString operation identifier ("+", "-", "*", "/" etc.)
     * @param value1          instance of class Operation, first operand for result Operation() instance
     * @param value2          instance of class Operation, second operand for result Operation() instance
     * @return resulting instance of Operation()
     * @throws UnsupportedOperationException for unsupported operation identifiers
     */
    private static Operation binaryOperation(String operationString, Operation value1, Operation value2) {
        switch (operationString) {
            case "+":
                return new Sum(value1, value2);
            case "-":
                return new Subtract(value1, value2);
            case "*":
                return new Multiply(value1, value2);
            case "/":
                return new Divide(value1, value2);
            case "^":
                return new Pow(value1, value2);
            default:
                throw new UnsupportedOperationException("Operation did not implemented yet: " + operationString);
        }
    }

    /**
     * <p>Returns an unary operation for given operationString(identifier), and one operand</p>
     *
     * @param operationString operation identifier ("sin", "cos", "tan", "sqrt" etc.)
     * @param value           instance of class Operation, operand for resulting Operation() instance
     * @return resulting instance of Operation()
     * @throws UnsupportedOperationException for unsupported operation identifiers
     */
    private static Operation unaryOperation(String operationString, Operation value) {
        switch (operationString) {
            case "sin":
                return new Sin(value);
            case "cos":
                return new Cos(value);
            case "sqrt":
                return new Sqrt(value);
            default:
                throw new UnsupportedOperationException("Operation did not implemented yet: " + operationString);
        }
    }

    /**
     * <p>Returns a math constant (double value) for given operationString(identifier)</p>
     *
     * @param operationString constant identifier ("pi", "e")
     * @return resulting instance of Operation()
     * @throws UnsupportedOperationException for unsupported constant identifiers
     */
    private static Operation constant(String operationString) {
        // Returns an instance of Value operation, which contains a numeric value of math constants
        switch (operationString) {
            case "pi":
                return new Value(Math.PI);
            case "e":
                return new Value(Math.E);
            default:
                throw new UnsupportedOperationException("Operation did not implemented yet: " + operationString);
        }
    }

    /**
     * <p>Converts an array of PRN sorted operationStrings to an instance of Operation()</p>
     *
     * @param operationStrings array operation identifiers {"3", "2", "-"}
     * @return resulting instance of Operation()
     * @throws IllegalArgumentException if identifier doesn't fit to supported operations
     */
    private static Operation finalOperation(String[] operationStrings) {
        Stack<Operation> stack = new Stack<Operation>();

        for (String operationString : operationStrings) {
            if (OperatorParser.isNumericString(operationString)) {
                stack.push(new Value(Double.parseDouble(operationString)));
            } else if (OperatorParser.isConstant(operationString)) {
                // create a Value, which contains a Math constant (pi, e etc.)
                stack.push(constant(operationString));
            } else if (OperatorParser.isBinary(operationString)) {
                // if operation is binary, pop two operations from stack and create new binary operation
                Operation secondOperand = stack.pop();
                Operation firstOperand = stack.pop();
                stack.push(binaryOperation(operationString, firstOperand, secondOperand));
            } else if (OperatorParser.isUnary(operationString)) {
                // if operation is unary, pop operation from stack and create new operation
                Operation operand = stack.pop();
                stack.push(unaryOperation(operationString, operand));
            } else {
                throw new IllegalArgumentException("Incorrect operation: " + operationString);
            }
        }
        // final operation in our stack
        return stack.pop();
    }

    /**
     * <p>Returns an array of operation strings for polish reversed notation</p>
     *
     * @param inputString string with math expression like "3 + 2"
     * @return PRN sorted array of operation strings {"3", "2", "+"}
     */
    private static String[] polishReverseOrderedArrayOfOperationStringsFrom(String inputString) {
        inputString = inputString.toLowerCase();

        String[] originalArray = OperatorParser.operationStringsFromString(inputString);
        String[] finalArray = new String[originalArray.length];
        Stack<String> operationStack = new Stack<>();
        int counter = 0;
        //operationStringsQueue = new Queue();
        for (String operand : originalArray) {
            if (OperatorParser.isNumericString(operand)) { //If symbol is number -> add it to the final string.
                finalArray[counter++] = operand;
            } else if (OperatorParser.isConstant(operand)) {
                finalArray[counter++] = operand;
            } else if (OperatorParser.isFunction(operand)) { // Add function symbol to the stack
                operationStack.push(operand);
            } else if (operand.equals("(")) { //Add open brace to the stack
                operationStack.push(operand);
            } else if (operand.equals(")")) {
                while ((!operationStack.isEmpty()) && (!operationStack.peek().equals("("))) {
                    String topOperand = operationStack.pop();
                    finalArray[counter++] = topOperand;
                }

                operationStack.pop();
                if (!operationStack.isEmpty()) {

                    if (OperatorParser.isFunction(operationStack.peek())) {
                        String topOperand = operationStack.pop();
                        finalArray[counter++] = topOperand;
                    }
                }
            } else if (OperatorParser.isOperator(operand)) {
                boolean flag = operationStack.isEmpty();
                while (!flag && (OperatorParser.operationPriority(operand) <= OperatorParser.operationPriority(operationStack.peek()))) {
                    String topOperand = operationStack.pop();
                    finalArray[counter++] = topOperand;
                    flag = operationStack.isEmpty();
                }
                //System.out.println("Add operation to queue " + operand);
                operationStack.push(operand);
            } else {
                // Wrong argument
                throw new IllegalArgumentException("Illegal argument: " + operand);
            }
        }
        while (!operationStack.isEmpty()) {
            finalArray[counter++] = operationStack.pop();
        }
        String[] resizedArray = new String[counter];
        System.arraycopy(finalArray, 0, resizedArray, 0, counter);

        return resizedArray;
    }
}
