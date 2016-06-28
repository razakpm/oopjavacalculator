package com.cvtalks;

/*
Update by Yuriy Ganusyak 17.09.2015
Class throws "Division by zero exception"
 */

public class Divide extends BinaryOperation {
    final Operation x;
    final Operation y;

    public Divide(Operation x, Operation y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double evaluate() {
        if (y.evaluate() == 0) {
            throw new IllegalArgumentException("Division by zero");
        } else {
            return x.evaluate() / y.evaluate();
        }

    }

    @Override
    public String toString() {
        String firstString = x.toString();
        String secondString = y.toString();
        if (y.getDepth() > 0) {
            firstString = "(" + firstString + ")";
        }
        if (y.getDepth() > 0) {
            secondString = "(" + secondString + ")";
        }

        return firstString + " / " + secondString;
    }

    @Override
    public Operation firstArgument() {
        return x;
    }

    @Override
    public Operation secondArgument() {
        return y;
    }

    public static Divide Of(Operation x, Operation y) {
        return new Divide(x, y);
    }

    @Override
    public void accept(OperationVisitor visitor) {
        visitor.visit(this);
    }
}