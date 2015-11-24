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

/**
 * <一句话功能简述> <功能详细描述>
 * 
 * @author yangzc 2015年8月28日
 */
public class RealSubject implements Subject {
    public void doSomething() {
        System.out.println("call doSomething()");
    }
}
