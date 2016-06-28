package com.cvtalks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author: Petruk Eugen
 */
public class LatexTest {

    @Test
    public void returnsCorrectLatexStringOutput() {
        Value seven = new Value(7);
        Variable X = new Variable("X");
        Operation sum = new Sum(seven,X);
        Operation pow = new Pow(sum,sum);
        String LatexStr = LATEX.toString(pow);
        assertEquals("\\left(7.0+X\\right)^{7.0+X}", LatexStr);
    }

    @Test
    public void returnsCorrectLatexStringOutputBig() {
        Value seven = new Value(7);
        Variable X = new Variable("X");
        Operation sum = new Sum(seven,X);
        Operation pow = new Pow(sum,sum);
        Operation sin = new Sin(pow);
        Operation dev = new Divide(sin,sum);
        String LatexStr = LATEX.toString(dev);
        assertEquals("\\frac{\\sin\\left(\\left(7.0+X\\right)^{7.0+X}\\right)}{7.0+X}", LatexStr);
    }
}
