package com.demo.configexample;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.example")
public class ConfigProperties {

    private Integer integerValue;
    private Double decimalValue;
    private Boolean booleanValue;

    // Getters and Setters

    public Integer getIntegerValue() {
        return integerValue;
    }

    public void setIntegerValue(Integer integerValue) {
        this.integerValue = integerValue;
    }

    public Double getDecimalValue() {
        return decimalValue;
    }

    public void setDecimalValue(Double decimalValue) {
        this.decimalValue = decimalValue;
    }

    public Boolean getBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(Boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public void printValues() {
        System.out.println("Integer Value: " + integerValue);
        System.out.println("Double Value: " + decimalValue);
        System.out.println("Boolean Value: " + booleanValue);
    }
}


