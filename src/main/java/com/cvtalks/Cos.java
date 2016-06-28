package com.cvtalks;

import java.lang.Math;

/**
 * Created by y.ganusyak on 13.09.15.
 */
public class Cos extends UnaryOperation {
    final Operation _operation;

    public Cos(Operation operation) {
        _operation = operation;
    }

    @Override
    public double evaluate() {
        return Math.cos(_operation.evaluate());
    }

    @Override
    public String toString() {
        return "cos(" + _operation.toString() + ")";
    }

    @Override
    public Operation getArgument() {
        return _operation;
    }

    @Override
    public void accept(OperationVisitor visitor) {
        visitor.visit(this);
    }
}
