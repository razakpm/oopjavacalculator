package com.cvtalks;

/**
 * Created by yuriyganusyak on 9/17/15.
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class PowTest {
    @Test
    public void canCalculatePows() {
        Operation firstOperand = new Value(2.0);
        Operation secondOperand = new Value(3.0);
        Operation pow = new Pow(firstOperand, secondOperand);
        assertEquals(8.0, pow.evaluate(), 1e-6);
    }

    @Test
    public void returnsCorrectStringOutput() {
        Operation firstOperand = new Value(2.0);
        Operation secondOperand = new Value(3.0);
        Operation pow = new Pow(firstOperand, secondOperand);
        assertEquals("pow(2.0,3.0)", pow.toString());
    }
}
