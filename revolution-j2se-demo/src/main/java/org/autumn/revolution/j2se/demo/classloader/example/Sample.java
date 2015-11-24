package org.autumn.revolution.j2se.demo.classloader.example;

public class Sample {
    private Sample instance;

    public void setSample(Object instance) {
        this.instance = (Sample) instance;
    }
}
