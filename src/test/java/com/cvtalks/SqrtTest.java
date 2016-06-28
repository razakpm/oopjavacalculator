package com.cvtalks;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by yuriyganusyak on 9/17/15.
 */
public class SqrtTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void canCalculateSqrt() {
        Operation fourValue = new Value(4.0);
        Operation sqrt = new Sqrt(fourValue);
        assertEquals(2.0, sqrt.evaluate(), 1e-6);
    }

    @Test
         public void throwsExceptionForNegativeOperand() {
        Operation negativeFourValue = new Value(-4.0);
        Operation sqrt = new Sqrt(negativeFourValue);
        thrown.expect(ArithmeticException.class);
        thrown.expectMessage("Argument is less than zero");
        sqrt.evaluate();
    }

    @Test
    public void returnsCorrectStringOutput() {
        Operation fourValue = new Value(4.0);
        Operation sqrt = new Sqrt(fourValue);
        assertEquals("sqrt(4.0)", sqrt.toString());
    }
}
