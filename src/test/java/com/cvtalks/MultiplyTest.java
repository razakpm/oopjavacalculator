package com.cvtalks;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yuriyganusyak on 9/17/15.
 */
public class MultiplyTest {
    @Test
    public void canMultiplyValues() {
        Value seven = new Value(7.0);
        Value two = new Value(2.0);
        Operation multiply = new Multiply(seven, two);
        assertEquals(14.0, multiply.evaluate(), 1e-6);
    }

    @Test
    public void returnsCorrectStringOutput() {
        Value seven = new Value(7.0);
        Value two = new Value(2.0);
        Operation multiply = new Multiply(seven, two);
        assertEquals("7.0 * 2.0", multiply.toString());
    }

    @Test
    public void returnsCorrectOutputWithNesting() {
        Operation op = Multiply.Of(Sum.Of(Value.Of(1), Value.Of(2)), Value.Of(1));
        assertEquals("(1.0 + 2.0) * 1.0", op.toString());
    }
}