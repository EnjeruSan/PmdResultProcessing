package ru.sbt;

public class RulesInfo {
    private String ruleName;
    private String methodName;
    private Double value;

    public RulesInfo() {
        // Чтобы был
    }

    public RulesInfo(String methodName, String ruleName, Double value) {
        this.methodName = methodName;
        this.ruleName = ruleName;
        this.value = value;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String className) {
        this.methodName = className;
    }
}
