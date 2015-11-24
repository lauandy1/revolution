package org.autumn.revolution.j2se.demo.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by yangzhichao on 15/9/16.
 */
public class ReflectionDemo {

    public String getName(){
        return "yang";
    }

    private String getValue(String value){
        return value;
    }

    private int getLength(int[] nums){
        return nums.length;
    }






    public static void main(String[] args) {


        Class<ReflectionDemo> clazz = ReflectionDemo.class;
        try {
            Method method = clazz.getMethod("getName",null);
            String name = (String)method.invoke(new ReflectionDemo(),null);
            System.out.println(name);

            Method method1 = clazz.getDeclaredMethod("getValue", new Class[]{String.class});
            //method1.setAccessible(true);
            String value = (String)method1.invoke(new ReflectionDemo(),"testValue");
            System.out.println(value);

            Method method2 = clazz.getDeclaredMethod("getLength",new Class[]{int[].class});
            int length = (Integer)method2.invoke(new ReflectionDemo(),new int[]{1,2,3});
            System.out.println(length);

            Method[] mm = clazz.getMethods();
            Method[] mm1 = clazz.getDeclaredMethods();
            System.out.println(Arrays.asList(mm));
            System.out.println(Arrays.asList(mm1));



        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        //clazz.getMethod();
    }


}
