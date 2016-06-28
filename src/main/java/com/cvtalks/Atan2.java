package com.cvtalks;

/**
 * Simple operation that returns constant value
 */
public class Atan2 extends BinaryOperation {

    final Operation _y;
    final Operation _x;

    public Atan2(Operation y, Operation x) {
        _y = y;
        _x = x;
    }

    public double evaluate() {
        return Math.atan2(_y.evaluate(), _x.evaluate());
    }

    @Override
    public String toString() {
        return "atan2(" + _y.toString() + "," + _x.toString() + ")";
    }

    @Override
    public Operation firstArgument() {
        return _x;
    }

    @Override
    public Operation secondArgument() {
        return _y;
    }

    @Override
    public void accept(OperationVisitor visitor) {
        visitor.visit(this);
    }
}