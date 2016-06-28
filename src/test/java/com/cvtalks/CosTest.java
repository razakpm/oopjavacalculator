package com.cvtalks;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yuriyganusyak on 9/17/15.
 */
public class CosTest {

    @Test
    public void cos0() {
        Value zero = new Value(0);
        Operation cos_zero = new Cos(zero);
        assertEquals(1, cos_zero.evaluate(), 1e-6);
    }

    @Test
    public void cos90() {
        Value PIby2 = new Value(Math.PI / 2);
        Operation cos_piby2 = new Cos(PIby2);
        assertEquals(0, cos_piby2.evaluate(), 1e-6);
    }

    @Test
    public void cos180() {
        Value pi = new Value(Math.PI);
        Operation cosPi = new Cos(pi);
        assertEquals(-1, cosPi.evaluate(), 1e-6);
    }

    @Test
    public void returnsCorrectStringOutput() {
        Value zero = new Value(0.0);
        Operation cos_zero = new Cos(zero);
        assertEquals("cos(0.0)", cos_zero.toString());
    }

}