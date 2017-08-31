package org.autumn.revolution.j2se.demo.init;

/**
 * Created by yangzhichao on 17/7/13.
 */
public class InitDemo {

    static {
        System.out.println("hi");
    }

    private static int num = 10;

    private static void printNum(){
        System.out.println(num);
    }

    public InitDemo(){
        System.out.println("---------init-----------");
    }

    public static void main(String[] args) {
        System.out.println(InitDemo.num);
        //printNum();
        //InitDemo initDemo = new InitDemo();
    }
}
