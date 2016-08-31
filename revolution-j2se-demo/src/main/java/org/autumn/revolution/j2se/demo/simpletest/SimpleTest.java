package org.autumn.revolution.j2se.demo.simpletest;


import org.autumn.revolution.j2se.demo.util.DESedeUtil;
import org.autumn.revolution.j2se.demo.util.MD5Util;

import java.util.Random;

/**
 * Created by yangzhichao on 15/10/13.
 */
public class SimpleTest {

    public static int fibonacci(int n){
        if(n==1||n==2) return 1;
        else {
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    public static int binarySearch(int n, int[] array,int start ,int end){
        int base = (start+end)/2;
        if(base==0){
            if(n==array[0]){
                return 0;
            }else if(n==array[1]){
                return 1;
            }else {
                return -1;
            }
        }
        if(n==array[base]){
            return base;
        }else if(n<array[base]){
            return binarySearch(n,array,start,base-1);
        }else if(n>array[base]){
            return binarySearch(n,array,base+1,end);
        }
        return -1;
    }

    // 生成验证码的位数
    private static final int num = 4;

    private static final byte[] keyBytes = { 0x11, 0x22, 0x4F, 0x58, (byte) 0x88, 0x10, 0x40, 0x38, 0x28, 0x25, 0x79,
            0x51, (byte) 0xCB, (byte) 0xDD, 0x55, 0x66, 0x77, 0x29, 0x74, (byte) 0x98, 0x30, 0x40, 0x36, (byte) 0xE2 }; // 24字节的密钥



    public static String getRandomString() {
        String result = null;
        String rand = "";
        Random random = new Random();
        char[] chars = new char[] { '5', 'd', 'e', 'g', 'h', '8', '6', 'K', 'n', 'O', 'p', 'R', '7', '9', 'S', 'T',
                '3', 'X', 'Y', '2', '4', 'A', 'B', 'E', 'F', 'G', 'H', 'P' };
        int charsLength = chars.length;
        for (int i = 0; i < num; i++) {
            rand = rand + String.valueOf(chars[random.nextInt(charsLength)]);
        }
        if (rand!=null&&rand.length()>0) {
            String md5String = MD5Util.md5(rand);
            byte[] encode = DESedeUtil.encryptMode(keyBytes, (md5String + rand).getBytes());
            result = DESedeUtil.byte2Hex(encode);
        }
        return result;
    }


    public static void main(String[] args) {
        long a = 11;
        //float f = 1.1;
        double d = 4.4f;

        //int x=3;int y=4; System.out.println(x=y);
        Integer x=new Integer(3);
        Integer y=new Integer(3);
        //System.out.println(x==y);

        int myArray [] = {10,20,30,40,50,60,70};
        int s = 0;
        for(int i =0;i<myArray.length;i++){
            if(i%2==1) s+=myArray[i];
        }
        //System.out.println(s);

       // System.out.println(fibonacci(6));

        System.out.println(binarySearch(20,myArray,0,myArray.length-1));


        System.out.println(getRandomString());



    }
}
