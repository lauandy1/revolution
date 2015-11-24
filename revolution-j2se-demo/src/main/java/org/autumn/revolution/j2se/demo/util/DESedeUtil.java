package org.autumn.revolution.j2se.demo.util;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by yangzhichao on 15/10/19.
 */
public class DESedeUtil {

   // private static final Log logger = LogFactory.getLog(DESedeUtil.class);

    /**
     ******************************* ThreeDesUtil**********************
     */
    private static final String Algorithm = "DESede"; // 定义加密算法,可用DES,DESede,Blowfish

    // keybyte为加密密钥，长度为24字节
    // src为被加密的数据缓冲区（源）
    public static byte[] encryptMode(byte[] keybyte, byte[] src) {
        try {
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
            // 加密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return c1.doFinal(src);// 在单一方面的加密或解密
        }
        catch (java.security.NoSuchAlgorithmException e1) {
            // TODO: handle exception
            e1.printStackTrace();
        }
        catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        }
        catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    // keybyte为加密密钥，长度为24字节
    // src为加密后的缓冲区
    public static byte[] decryptMode(byte[] keybyte, byte[] src) {
        try {
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);
            // 解密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return c1.doFinal(src);
        }
        catch (java.security.NoSuchAlgorithmException e1) {
            // TODO: handle exception
            //logger.info("error", e1);
        }
        catch (javax.crypto.NoSuchPaddingException e2) {
            //logger.info("error", e2);
        }
        catch (Exception e3) {
           // logger.info("error", e3);
        }
        return null;
    }

    // 将二进制转化为16进制字符串
    public static String byte2Hex(byte[] bs) {
        StringBuffer sb = new StringBuffer(bs.length * 2);
        for (int i = 0; i < bs.length; i++) {
            int temp = bs[i];
            // 把负数转换为正数
            while (temp < 0) {
                temp = temp + 256;
            }
            // 小于0F的数需要在前面补0
            if (temp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(temp, 16));
        }
        return sb.toString();
    }

    // 将16进制转换为二进制
    public static byte[] hex2Byte(String str) {
        byte[] bs = str.getBytes();
        int i = bs.length;
        byte[] outbs = new byte[i / 2];
        for (int j = 0; j < i; j = j + 2) {
            String temp = new String(bs, j, 2);
            outbs[j / 2] = (byte) Integer.parseInt(temp, 16);
        }
        return outbs;
    }

}
