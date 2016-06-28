package com.cvtalks;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValueTest {
    @Test
    public void canConstructValue() {
        Value value_of_42 = new Value(42);
        assertEquals(Double.toString(42), value_of_42.toString());
        assertEquals(42.0, value_of_42.evaluate(), 1e-6);
    }

    @Test
    public void calculatesDepthCorrectly() {
        Value ten = new Value(10);
        assertEquals(0, ten.getDepth());
    }

    @Test
    public void canConstructValueWithOf() {
        Value ten = Value.Of(10);
        assertEquals(10, ten.evaluate(), 1e-6);
    }
}
