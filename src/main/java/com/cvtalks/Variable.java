package com.cvtalks;

/**
 * @author: Petruk Eugen
 */
public class Variable implements Operation {
    final String m_value;

    public Variable(String val) {
        m_value = val;
    }

    @Override
    public double evaluate() {
        throw new UnsupportedOperationException("Variable.evaluate() is not supported");
    }

    @Override
    public String toString() {
        return m_value;
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
    public static Variable Of(String val) {
        return new Variable(val);
    }
}
