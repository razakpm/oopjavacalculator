package com.cvtalks;

/**
 * This class represents base class for all arithmetic operations.
 * We consider "/", "+", etc as math operators and numeric constants are also operations that return constant value.
 */
public interface Operation {

    /**
     * Return result of the evaluation of the current operation and all underlying operations.
     *
     * @return Value of this operation
     */
    double evaluate();

    /**
     * Converts current operation to string representation
     *
     * @return String representation of current operation like "1+4".
     */
    @Override
    String toString();

    /**
     * Return a number of nested operations for current operation.
     *
     * @return Value of this operation
     */
    int getDepth();

    public void accept(OperationVisitor visitor);

}

