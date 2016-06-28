package com.cvtalks;

//Return the value of the number x to be the power of y

public class Pow extends BinaryOperation {

    final Operation x;
    final Operation y;

    public Pow(Operation x, Operation y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double evaluate() {
        return Math.pow(x.evaluate(), y.evaluate());
    }

    @Override
    public String toString() {
        return "pow(" + x.toString() + "," + y.toString() + ")";
    }

    @Override
    public Operation firstArgument() {
        return x;
    }

    @Override
    public Operation secondArgument() {
        return y;
    }

    @Override
    public void accept(OperationVisitor visitor) {
        visitor.visit(this);
    }
}
