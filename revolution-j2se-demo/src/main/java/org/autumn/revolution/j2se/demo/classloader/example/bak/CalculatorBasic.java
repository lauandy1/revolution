package org.autumn.revolution.j2se.demo.classloader.example.bak;

import com.lauandy.j2se.classloader.ICalculator;

public class CalculatorBasic implements ICalculator {

    public String calculate(String expression) {
        return expression;
    }

    public String getVersion() {
        return "1.0";
    }

}
