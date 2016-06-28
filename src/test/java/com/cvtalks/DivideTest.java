package com.cvtalks;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by yuriyganusyak on 9/17/15.
 */
public class DivideTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void canDivideValues() {
        Value seven = new Value(7.0);
        Value two = new Value(2.0);
        Operation divide = new Divide(seven, two);
        assertEquals(3.5, divide.evaluate(), 1e-6);
    }

    @Test
    public void returnsCorrectStringOutput() {
        Value seven = new Value(7.0);
        Value two = new Value(2.0);
        Operation divide = new Divide(seven, two);
        assertEquals("7.0 / 2.0", divide.toString());
    }

    @Test
    public void throwsExceptionForDivisionByZero() {
        Value seven = new Value(7.0);
        Value zero = new Value(0.0);
        Operation divide = new Divide(seven, zero);
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Division by zero");
        divide.evaluate();
    }

    //@Test
    public void returnsCorrectOutputWithNesting() {
        Operation op = Divide.Of(Sum.Of(Value.Of(1), Value.Of(2)), Value.Of(1));
        assertEquals("(1.0 + 2.0) / 1.0", op.toString());
    }
}
