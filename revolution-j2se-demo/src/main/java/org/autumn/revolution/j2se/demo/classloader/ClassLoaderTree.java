package org.autumn.revolution.j2se.demo.classloader;

public class ClassLoaderTree {

    public static void main(String[] args) {
//        ClassLoader loader = ClassLoaderTree.class.getClassLoader();
//        while (loader != null) {
//            System.out.println(loader.toString());
//            loader = loader.getParent();
//        }
        System.out.println(Thread.currentThread().getContextClassLoader().toString());
    }
}
