package org.autumn.revolution.j2se.demo.innerclass;

public abstract class Base
{
    //抽象类的构造函数
    public Base(int i)
    {
        System.out.println("Base Constructor,i = " +  i);
    }
    
    public abstract void f(); 
}
