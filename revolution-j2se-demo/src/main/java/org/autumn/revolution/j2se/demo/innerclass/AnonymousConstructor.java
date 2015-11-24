package org.autumn.revolution.j2se.demo.innerclass;

public class AnonymousConstructor {
  //注意该类中不一定要求i是final的，因为i被传递给匿名内部类的基类的构造器，并不会在匿名内部类被直接使用。
    public static Base getBase(int i)
    {
        return new Base(i)
        {
            //这相当于普通类中的实例初始化块
            {System.out.println("Inside instance initializer");}
            
            @Override
            public void f()
            {
                System.out.println("In Anonymous f()");
            }
        };
    }
    
  
    
    public static void main(String... args)
    {
        Base base = getBase(3);
        base.f();
    }

}
