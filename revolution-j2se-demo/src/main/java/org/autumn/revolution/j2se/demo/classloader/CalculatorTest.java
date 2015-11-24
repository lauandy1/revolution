package org.autumn.revolution.j2se.demo.classloader;


public class CalculatorTest {

    public static void main(String[] args) {
        String url = "http://localhost:8080/ClassloaderTest/classes";
        NetworkClassLoader ncl = new NetworkClassLoader(url);

        // 将example包下面的类编译好之后拷贝到web目录下，然后删除，在本地就没有这几个类了。
        // 然后通过网络类加载器从web资源获取class文件，然后加载器进行加载，然后通过反射实例化接口的实例，
        // 但是在本地不能显示的声明接口的实现类，因为本地并不存在具体实现，但是反射生成的实例确实是对应的
        // 实现类的实例，通过方法调用可以看出。
        String basicClassName = "com.lauandy.j2se.classloader.example.CalculatorBasic";
        String advancedClassName = "com.lauandy.j2se.classloader.example.CalculatorAdvanced";
        String commonClassName = "com.lauandy.j2se.classloader.example.CalculatorCommon";
        try {
            Class<?> clazz = ncl.loadClass(basicClassName);
            ICalculator calculator = (ICalculator) clazz.newInstance();
            System.out.println(calculator.getVersion());
            clazz = ncl.loadClass(advancedClassName);
            calculator = (ICalculator) clazz.newInstance();
            System.out.println(calculator.getVersion());
            clazz = ncl.loadClass(commonClassName);
            calculator = (ICalculator) clazz.newInstance();
            System.out.println(calculator.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
