package org.autumn.revolution.j2se.demo.algorithm.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：TODO
 * Author: yangzhichao
 * Date: 2021/12/6
 */
public class StringUtils {

    public static final String DOT = ".";
    public static final String SLANTING_BAR = "/";


    public static void splitBy(String testStr, List<String> resList) {
        if (testStr == null || testStr.length() == 0) {
            return;
        }
        // 字符串是一个DOT这种特殊情况特殊处理
        if (testStr.equals(DOT)) {
            resList.add("");
            resList.add("");
            return;
        }
        int length = testStr.length();
        boolean haveChild = false;
        for (int i = 0; i < length; i++) {
            String charStr = String.valueOf(testStr.charAt(i));
            if (SLANTING_BAR.equals(charStr) && i + 1 < length) {
                String nextCharStr = String.valueOf(testStr.charAt(i + 1));
                // 从字符串中删除该转义符/DOT,并对下一个字符不进行解析
                if (DOT.equals(nextCharStr) || SLANTING_BAR.equals(nextCharStr)) {
                    testStr = testStr.substring(0, i) + testStr.substring(i + 1, length);
                    length = length - 1;
                }
            } else if (DOT.equals(charStr)) {
                haveChild = true;
                resList.add(testStr.substring(0, i));
                String rightString = testStr.substring(i + 1, length);
                splitBy(rightString, resList);
                break;
            }
        }
        if (null != testStr && !haveChild) {
            resList.add(testStr);
        }
        return;
    }


    public static List<String> splitBy(String src){
        List<String> resList = new ArrayList<>();
        if(src != null && src.length() == 0){
            resList.add("");
            return resList;
        }
        int lastSplitPos = -1;
        for(int i = 0; i < src.length(); i++){
            String curStr = String.valueOf(src.charAt(i));
            if(SLANTING_BAR.equals(curStr) && i + 1 < src.length()){
                String nextStr = String.valueOf(src.charAt(i + 1));
                // 如果转义后面是转义或者分隔符，则对原始字符串进行处理
                if(DOT.equals(nextStr) || SLANTING_BAR.equals(nextStr)){
                    src = src.substring(0, i) + src.substring(i + 1, src.length());
                }
            }else if(DOT.equals(curStr)){
                // 如果是分隔符，则开始切分，分隔符前半部分放入list
                resList.add(src.substring(lastSplitPos + 1, i));
                lastSplitPos = i;
            }
        }
        // 最后处理下最后一个分隔符后面剩余的字符串
        resList.add(src.substring(lastSplitPos + 1, src.length()));
        return resList;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        String s = "///";
        String s = "1.";
//        String s = "1//.1/..1";
//        String src = "///.";
        splitBy(s, list);
        //list = splitBy(src);
        for(String s1 : list){
            System.out.println(s1);
        }
    }


}
