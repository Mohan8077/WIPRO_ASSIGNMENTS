package com.demo.useraccountss;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.example")
public class AppProperties {

    private int integerValue;
    private double decimalValue;
    private boolean booleanValue;

    // Getters and Setters
    public int getIntegerValue() {
        return integerValue;
    }

    public void setIntegerValue(int integerValue) {
        this.integerValue = integerValue;
    }

    public double getDecimalValue() {
        return decimalValue;
    }

    public void setDecimalValue(double decimalValue) {
        this.decimalValue = decimalValue;
    }

    public boolean isBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    @Override
    public String toString() {
        return "Integer: " + integerValue + ", Decimal: " + decimalValue + ", Boolean: " + booleanValue;
    }
}
