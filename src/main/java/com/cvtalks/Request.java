package com.cvtalks;

public class Request {
    private String content;
    //private String value;

    public String getValue () throws ArithmeticException,IllegalArgumentException {
        try {
            double value = PRNCalculator.calculate(content);
            return String.valueOf(PRNCalculator.calculate(content));
        } catch (Exception e) {
            throw new ArithmeticException();
        }

    }

    public String getPrn () {
        return PRNCalculator.getPRNString(content);
    }

    public boolean isValid() {
        return OperatorParser.isValidString(content);
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
}