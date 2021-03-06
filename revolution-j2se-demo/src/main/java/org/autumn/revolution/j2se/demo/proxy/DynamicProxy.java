/*
 * Copyright (c) 2015 金联所. All rights reserved.
 *
 * The copyright to the computer software herein is the property of 金联所.
 * The software may be used and/or copied only with the written permission 
 * of 金联所, or in accordance with the terms and conditions stipulated in 
 * the agreement/contract under which the software has been supplied.
 *
 */
package org.autumn.revolution.j2se.demo.proxy;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author yangzc 2015年8月28日
 */
public class DynamicProxy {

    public static void main(String args[]) {
        RealSubject real = new RealSubject();
        Subject proxySubject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(), new Class[] { Subject.class }, new ProxyHandler(real));

        proxySubject.doSomething();

        // write proxySubject class binary data to file
        createProxyClassFile();
    }

    public static void createProxyClassFile() {
        String name = "ProxySubject";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[] { Subject.class });
        try {
            FileOutputStream out = new FileOutputStream(name + ".class");
            out.write(data);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
