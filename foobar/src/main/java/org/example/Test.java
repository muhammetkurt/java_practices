package org.example;

public class Test {
    private String testString;

    private int testInteger;

    public Test(String testString, int testInteger) {
        this.testString = testString;
        this.testInteger = testInteger;
    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    public int getTestInteger() {
        return testInteger;
    }

    public void setTestInteger(int testInteger) {
        this.testInteger = testInteger;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testString='" + testString + '\'' +
                ", testInteger=" + testInteger +
                '}';
    }
}
