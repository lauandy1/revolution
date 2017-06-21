package org.autumn.revolution.j2se.demo.classloader.example.bak;


import org.autumn.revolution.j2se.demo.classloader.ICalculator;

public class CalculatorBasic implements ICalculator {

    public String calculate(String expression) {
        return expression;
    }

    public String getVersion() {
        return "1.0";
    }

}
