package com.cvtalks;

public class Neg extends UnaryOperation {

    final Operation x;

    public Neg(Operation x) {
        this.x = x;
    }

    @Override
    public double evaluate() {
        if (x.evaluate() == 0) {
            return x.evaluate();
        }
        return -x.evaluate();
    }

    @Override
    public String toString() {
        return "neg(" + x.toString() + ")";
    }

    @Override
    public Operation getArgument() {
        return x;
    }

    @Override
    public void accept(OperationVisitor visitor) {
        visitor.visit(this);
    }
}
