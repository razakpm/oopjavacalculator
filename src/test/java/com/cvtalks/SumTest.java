package com.cvtalks;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yuriyganusyak on 9/17/15.
 */
public class SumTest {
    @Test
    public void canAddValues() {
        Value seven = new Value(7.0);
        Value two = new Value(2.0);
        Operation sum = new Sum(seven, two);
        assertEquals(9.0, sum.evaluate(), 1e-6);
    }

    @Test
    public void makesCorrectStringOutputSimple() {
        Value seven = new Value(7.0);
        Value two = new Value(2.0);
        Operation sum = new Sum(seven, two);
        assertEquals("7.0 + 2.0", sum.toString());
    }

    @Test
    public void makesCorrectStringoutputBraces() {
        // (2 + 3) + 4
        Operation sum = new Sum(new Sum(new Value(2.0), new Value(3.0)), new Value(4.0));
        assertEquals("(2.0 + 3.0) + 4.0", sum.toString());
    }
}