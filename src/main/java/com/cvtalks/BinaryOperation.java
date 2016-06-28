package com.cvtalks;

/**
 * @author: Petruk Eugen
 */
abstract public class BinaryOperation implements Operation {
    public abstract double evaluate();

    public abstract String toString();

    public abstract Operation firstArgument();

    public abstract Operation secondArgument();

    public int getDepth() {
        if (firstArgument().getDepth() >= secondArgument().getDepth()) {
            return firstArgument().getDepth() + 1;
        } else
            return secondArgument().getDepth() + 1;
    }
}
