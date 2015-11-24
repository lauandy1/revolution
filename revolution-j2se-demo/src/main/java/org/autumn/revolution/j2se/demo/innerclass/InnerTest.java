

package org.autumn.revolution.j2se.demo.innerclass;


public class InnerTest {
    
    private class Contents{
        public int value() {
            return 0;
        }
    }
    
    public Contents contents()
    {
     //匿名内部类，匿名，没有名字，创建一个继承自Contents的匿名类的对象.通过new表达式返回的引用被自动向上转型为对Contents的引用
     return new Contents()
     {
      private int i = 3;
      
      @Override
      public int value()
      {
       return i;
      }
     };
    }
    
    private class Wrapping{
        private int x ;
        public Wrapping(int x){
            this.x = x;
        }
        public int value(){
            return x*2;
        }
    }
    
    public Wrapping wrapping(int x)
    {
     //注意看这里的用法，即使Wrapping是一个普通类，但其还是被其导出类当做”公共接口“来使用
     
     return new Wrapping(x)
     {
      //更要注意，这里用到了Override关键字，说明返回的这个匿名内部类是Wrapping的一个导出类
      @Override
      public int value()
      {
       return super.value() * 3;
      }
     };
    }
    
    public Runnable getRunnable(){
        return new Runnable() {
            
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("run...");
            }
        };
    }
    
    public static void main(String[] args) {
        InnerTest innerTest = new InnerTest();
        Contents contents = innerTest.contents();
        System.out.println(contents.value());
        
        Wrapping wrapping = innerTest.wrapping(2);
        System.out.println(wrapping.value());
    }

}
