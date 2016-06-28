package com.cvtalks;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class NegTest {

    @Test
    public void canAddValues() {
        Value seven = new Value(7.0);
        Operation neg = new Neg(seven);
        assertEquals(-7.0, neg.evaluate(), 1e-6);
    }

    @Test
    public void zeroNeg() {
        Operation value = new Value(0.0);
        Operation neg = new Sqrt(value);
        assertEquals(0.0, neg.evaluate(), 1e-6);
    }


    @Test
    public void returnsCorrectStringOutput() {
        Operation value = new Value(5.0);
        Operation neg = new Neg(value);
        assertEquals("neg(5.0)", neg.toString());
    }
}
