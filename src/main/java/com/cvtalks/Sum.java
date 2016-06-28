package com.cvtalks;

public class Sum extends BinaryOperation {
    final Operation x;
    final Operation y;

    public Sum(Operation x, Operation y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double evaluate() {
        return x.evaluate() + y.evaluate();
    }

    @Override
    public String toString() {
        String firstString = x.toString();
        String secondString = y.toString();
        if (x.getDepth() > 0) {
            firstString = "(" + firstString + ")";
        }
        if (y.getDepth() > 0) {
            secondString = "(" + secondString + ")";
        }

        return firstString + " + " + secondString;
    }

    @Override
    public Operation firstArgument() {
        return x;
    }

    @Override
    public Operation secondArgument() {
        return y;
    }

    /**
     * Helper method to create operation without new syntax.
     */
    public static Sum Of(Operation x, Operation y) {
        return new Sum(x, y);
    }

    @Override
    public void accept(OperationVisitor visitor) {
        visitor.visit(this);
    }
}