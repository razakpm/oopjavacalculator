package com.cvtalks;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


public class SubtractTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void canSubtractValues() {
        Value seven = new Value(7.0);
        Value two = new Value(2.0);
        Operation subtract = new Subtract(seven, two);
        assertEquals(5, subtract.evaluate(), 1e-6);
    }

    @Test
    public void returnsCorrectStringOutput() {
        Value seven = new Value(7.0);
        Value two = new Value(2.0);
        Operation subtract = new Subtract(seven, two);
        assertEquals("7.0 - 2.0", subtract.toString());
    }

    @Test
    public void makesCorrectStringOutputBraces() {
        Operation subtract = new Subtract(new Subtract(new Value(8.0), new Value(2.0)), new Value(3.0));
        assertEquals("(8.0 - 2.0) - 3.0", subtract.toString());
    }

}
