package org.autumn.revolution.j2se.demo.classloader.example.bak;


import org.autumn.revolution.j2se.demo.classloader.ICalculator;

public class CalculatorAdvanced implements ICalculator {

    public String calculate(String expression) {
        return "Result is " + expression;
    }

    public String getVersion() {
        return "2.0";
    }

}
