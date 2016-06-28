package com.cvtalks;

/**
 * @author: Petruk Eugen
 */
abstract public class UnaryOperation implements Operation {

    public abstract double evaluate();

    public abstract String toString();

    public abstract Operation getArgument();

    public int getDepth() {
        return getArgument().getDepth() + 1;
    }


}

