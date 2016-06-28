package com.cvtalks;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by yuriyganusyak on 9/17/15.
 */
public class OperatorParserTest {
    
    @Test
    public void checkValid() {
        assertEquals(true, OperatorParser.bracesBalanced(""));
        assertEquals(true, OperatorParser.bracesBalanced("(()())"));
        assertEquals(true, OperatorParser.bracesBalanced("(()(()()))"));
        assertEquals(true, OperatorParser.isParenthesis("("));
        assertEquals(true, OperatorParser.isParenthesis(")"));
        assertEquals(true, OperatorParser.isNumericString("1.0231"));
        assertEquals(2.0, (double)OperatorParser.operationPriority("*"), 1e-2);
        assertEquals(2.0, (double)OperatorParser.operationPriority("/"), 1e-2);
        assertEquals(3.0, (double)OperatorParser.operationPriority("^"), 1e-2);
        assertEquals(1.0, (double)OperatorParser.operationPriority("+"), 1e-2);
        assertEquals(1.0, (double)OperatorParser.operationPriority("-"), 1e-2);
        assertEquals(true, OperatorParser.isFunction("sin"));
        assertEquals(true, OperatorParser.isFunction("cos"));
        assertEquals(true, OperatorParser.isFunction("sqrt"));
        assertEquals(true, OperatorParser.isFunction("sqr"));
        assertEquals(true, OperatorParser.isOperator("+"));
        assertEquals(true, OperatorParser.isOperator("-"));
        assertEquals(true, OperatorParser.isOperator("*"));
        assertEquals(true, OperatorParser.isOperator("/"));
        assertEquals(true, OperatorParser.isOperator("^"));

    }

    @Test
    public void checkInvalid() {
        assertEquals(false, OperatorParser.bracesBalanced(")("));
        assertEquals(false, OperatorParser.bracesBalanced(")"));
        assertEquals(false, OperatorParser.bracesBalanced("("));
        assertEquals(false, OperatorParser.bracesBalanced("(()))"));
        assertEquals(false, OperatorParser.bracesBalanced("(() ( hi))) (())()(((( ))))"));
        assertEquals(false, OperatorParser.isParenthesis("()"));
        assertEquals(false, OperatorParser.isNumericString("1.0r31"));
        assertEquals(false, OperatorParser.isFunction("cis"));
    }



}
