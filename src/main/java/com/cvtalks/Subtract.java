package com.cvtalks;

public class Subtract extends BinaryOperation {
    final Operation first;
    final Operation two;

    public Subtract(Operation x, Operation y) {
        first = x;
        two = y;
    }

    @Override
    public double evaluate() {
        return first.evaluate() - two.evaluate();
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

        return firstString + " - " + secondString;
    }

    @Override
    public Operation firstArgument() {
        return first;
    }

    @Override
    public Operation secondArgument() {
        return two;
    }

    public static Subtract Of(Operation x, Operation y) {
        return new Subtract(x, y);
    }

    @Override
    public void accept(OperationVisitor visitor) {
        visitor.visit(this);
    }
}
