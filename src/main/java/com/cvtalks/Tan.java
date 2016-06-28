package com.cvtalks;

import java.lang.Math;

/**
 * Created by y.ganusyak on 13.09.15.
 * Simple tan(x) class
 * returns double tan(x) and string "tan(value)"
 */
public class Tan extends UnaryOperation {
    final Operation _operation;

    public Tan(Operation operation) {
        _operation = operation;
    }

    @Override
    public double evaluate() {
        return Math.tan(_operation.evaluate());
    }

    @Override
    public String toString() {
        return "tan(" + _operation.toString() + ")";
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
