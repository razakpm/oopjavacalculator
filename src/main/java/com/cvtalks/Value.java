package com.cvtalks;

/**
 * Simple operation that returns constant value
 */
public class Value implements Operation {

    final double m_value;

    public Value(double val) {
        m_value = val;
    }

    @Override
    public double evaluate() {
        return m_value;
    }

    @Override
    public String toString() {
        return Double.toString(m_value);
    }

    @Override
    public int getDepth() {
        return 0;
    }

    @Override
    public void accept(OperationVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Helper method to create operation without new syntax.
     *
     * @param val Value to wrap
     * @return Instance of Value class containing given number.
     */
    public static Value Of(double val) {
        return new Value(val);
    }
}