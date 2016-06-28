package com.cvtalks;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yuriyganusyak on 9/17/15.
 */
public class SinTest {

    @Test
    public void sin0() {
        Value zero = new Value(0);
        Operation sinus_zero = new Sin(zero);
        assertEquals(0, sinus_zero.evaluate(), 1e-6);
    }

    @Test
    public void sin90() {
        Value PIby2 = new Value(Math.PI / 2);
        Operation sinus_piby2 = new Sin(PIby2);
        assertEquals(1, sinus_piby2.evaluate(), 1e-6);
    }

    @Test
    public void sin180() {
        Value pi = new Value(Math.PI);
        Operation sinusPi = new Sin(pi);
        assertEquals(0, sinusPi.evaluate(), 1e-6);
    }

    @Test
    public void sinToString() {
        Value zero = new Value(0.0);
        Operation sinus_zero = new Sin(zero);
        assertEquals("sin(0.0)", sinus_zero.toString());
    }

    public void calculatesDepthCorrectly() {
        Operation sin = new Sin(new Value(1));
        assertEquals(1, sin.getDepth());
    }

}
