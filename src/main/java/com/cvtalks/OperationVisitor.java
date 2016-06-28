package com.cvtalks;

public interface OperationVisitor {
    public void visit(Atan2 atan2);
    public void visit(Cos cos);
    public void visit(Divide divide);
    public void visit(Multiply multiply);
    public void visit(Neg neg);
    public void visit(Pow pow);
    public void visit(Sin sin);
    public void visit(Sqrt sqrt);
    public void visit(Subtract subtract);
    public void visit(Sum sum);
    public void visit(Tan tan);
    public void visit(Value value);
    public void visit(Variable variable);
}
