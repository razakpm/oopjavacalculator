package com.cvtalks;

//Return the square root of x

public class Sqrt extends UnaryOperation {

    final Operation x;

    public Sqrt(Operation x) {
        this.x = x;
    }

    @Override
    public double evaluate() {
        if (x.evaluate() < 0) {
            throw new ArithmeticException("Argument is less than zero");
        }
        return Math.sqrt(x.evaluate());
    }

    @Override
    public String toString() {
        return "sqrt(" + x.toString() + ")";
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