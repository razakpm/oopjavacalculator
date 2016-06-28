package com.cvtalks;

/**
 * @author: Petruk Eugen
 */

public class Multiply extends BinaryOperation {

    final Operation first;
    final Operation two;

    public Multiply(Operation m_l, Operation m_r) {
        first = m_l;
        two = m_r;
    }

    @Override
    public double evaluate() {

        return first.evaluate() * two.evaluate();
    }

    @Override
    public String toString() {
        String firstString = first.toString();
        String secondString = two.toString();
        if (first.getDepth() > 0) {
            firstString = "(" + firstString + ")";
        }
        if (two.getDepth() > 0) {
            secondString = "(" + secondString + ")";
        }

        return firstString + " * " + secondString;
    }

    @Override
    public Operation firstArgument() {
        return first;
    }

    @Override
    public Operation secondArgument() {
        return two;
    }

    public static Multiply Of(Operation x, Operation y) {
        return new Multiply(x, y);
    }

    @Override
    public void accept(OperationVisitor visitor) {
        visitor.visit(this);
    }
}
