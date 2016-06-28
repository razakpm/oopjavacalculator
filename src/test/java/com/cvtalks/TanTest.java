package com.cvtalks;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by yuriyganusyak on 9/17/15.
 */
public class TanTest {
    @Test
    public void tan0() {
        Value zero = new Value(0);
        Operation tanZero = new Tan(zero);
        assertEquals(0, tanZero.evaluate(), 1e-6);
    }

    @Test
    public void tan45() {
        Value PIby4 = new Value(Math.PI / 4);
        Operation tan45 = new Tan(PIby4);
        assertEquals(1, tan45.evaluate(), 1e-6);
    }


    @Test
    public void returnsCorrectStringOutput() {
        Value zero = new Value(0.0);
        Operation tanZero = new Tan(zero);
        assertEquals("tan(0.0)", tanZero.toString());
    }

    @Test
    public void calculatesDepthCorrectly() {
        Operation tan = new Tan(new Value(1));
        assertEquals(1, tan.getDepth());
    }

}
