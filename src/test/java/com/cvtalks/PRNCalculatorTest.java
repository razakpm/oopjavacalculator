package com.cvtalks;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


/**
 * Created by yuriyganusyak on 9/27/15.
 */
public class PRNCalculatorTest {
    @Test
    public void returnsCorrectResultsForCalculations() {
        assertEquals(1.0, PRNCalculator.calculate("sin(pi/2)"), 1e-6);
        assertEquals(3.5, PRNCalculator.calculate("3 + 4 * 2 / (1 - 5)^2"), 1e-6);
        Operation operation = PRNCalculator.getOperation("sin(pi/2)");
        assertEquals(1.0, operation.evaluate(), 1e-6);
    }

    @Test
    public void returnsCorrectOutputForComplexStrings() {
        assertEquals("3 4 2 * 1 5 - 2 ^ / +", PRNCalculator.getPRNString("3 + 4 * 2 / (1 - 5)^2"));
    }

    @Test
    public void correctOrderForBinaryOperations() {
        assertEquals(2.0, PRNCalculator.calculate("4 - 2"), 1e-6);
        assertEquals(2.0, PRNCalculator.calculate("4 / 2"), 1e-6);
        assertEquals(8.0, PRNCalculator.calculate("2 ^ 3"), 1e-6);
    }

    @Test
    public void classIsCaseInsensitive() {
        assertEquals(1.0, PRNCalculator.calculate("sin(pi/2)"), 1e-6);
        assertEquals(1.0, PRNCalculator.calculate("Sin(pi/2)"), 1e-6);
        assertEquals(1.0, PRNCalculator.calculate("Sin(pI/2)"), 1e-6);
    }




}
