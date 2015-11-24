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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author yangzc 2015年8月28日
 */
public class ProxyHandler implements InvocationHandler {
    private Object proxied;

    public ProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在转调具体目标对象之前，可以执行一些功能处理
        System.out.println("invoke before");

        // 转调具体目标对象的方法
        Object result = method.invoke(proxied, args);

        // 在转调具体目标对象之后，可以执行一些功能处理
        System.out.println("invoke after");

        return result;
    }
}
