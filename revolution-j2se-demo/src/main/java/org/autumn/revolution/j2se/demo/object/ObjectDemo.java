package org.autumn.revolution.j2se.demo.object;

import org.openjdk.jol.info.ClassLayout;

public class ObjectDemo {

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance("hello").toPrintable());
    }
}
