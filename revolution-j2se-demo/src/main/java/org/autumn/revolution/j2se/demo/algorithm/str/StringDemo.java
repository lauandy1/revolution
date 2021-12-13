package org.autumn.revolution.j2se.demo.algorithm.str;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 描述：TODO
 * Author: yangzhichao
 * Date: 2021/12/2
 */
public class StringDemo {


    public static String[] delimitedListToStringArray(String str, String delimiter, String charsToDelete) {
        if (str == null) {
            return new String[0];
        } else if (delimiter == null) {
            return new String[]{str};
        } else {
            List<String> result = new ArrayList();
            int pos;
            if ("".equals(delimiter)) {
                for(pos = 0; pos < str.length(); ++pos) {
                    result.add(deleteAny(str.substring(pos, pos + 1), charsToDelete));
                }
            } else {
                int delPos;
                for(pos = 0; (delPos = str.indexOf(delimiter, pos)) != -1; pos = delPos + delimiter.length()) {
                    result.add(deleteAny(str.substring(pos, delPos), charsToDelete));
                }

                if (str.length() > 0 && pos <= str.length()) {
                    result.add(deleteAny(str.substring(pos), charsToDelete));
                }
            }

            return toStringArray((Collection)result);
        }
    }

    public static String[] toStringArray(Collection<String> collection) {
        return collection == null ? null : (String[])collection.toArray(new String[collection.size()]);
    }

    public static String deleteAny(String inString, String charsToDelete) {
        if (hasLength(inString) && hasLength(charsToDelete)) {
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < inString.length(); ++i) {
                char c = inString.charAt(i);
                if (charsToDelete.indexOf(c) == -1) {
                    sb.append(c);
                }
            }
            return sb.toString();
        } else {
            return inString;
        }
    }

    public static boolean hasLength(String str) {
        return hasLength((CharSequence)str);
    }

    public static boolean hasLength(CharSequence str) {
        return str != null && str.length() > 0;
    }

    /**
     * 根据指定的分隔符对字符串切分，
     * 转义字符"/"规则：1.分隔符在单个转义字符后不生效 2.切分后转义字符本身要移除掉
     * @param src 输入字符串
     * @param pattern 分隔符
     * @return
     */
    public String[] split(String src, char pattern){
        // 非空判断
        if(src == null){
            return null;
        }
        // 初始化数组，长度设置为src的length
        List<String> res = new ArrayList<>();
        // 边界条件判断
        if(src.length() == 0){
            return (String[]) res.toArray();
        }
        // 转换为字符数组
        char[] cs = src.toCharArray();
        // 定义转义字符
        char magic = '/';
        // 循环中需要处理分隔符、转义字符；
        // 如果是转义字符，需要去掉转义字符本身；
        // 如果是分隔符，需看分隔符前面是否是转义字符，如果不是转义字符，则从此处位置之前的字符创建字符串
        // 定义2个位置变量
        int startPos = 0;
        for(int pos = 0; pos < cs.length; pos++){
            // 先处理边界
            if(pos == 0){
                if(cs[pos] == pattern){
                    res.add("");
                }
            }
            // 判断分隔符生效的条件，分隔符之前不是单个转义字符
            if(cs[pos] == pattern && cs[pos - 1] != magic){
                // 构造字符串
                String target = new String(cs, startPos, pos - startPos);
                // 处理字符串转义字符
            }
        }
        return (String[]) res.toArray();
    }

    public String deleteTarget(String src){
        return null;
    }


    public static final String DOT = ".";
    public static final String SLANTING_BAR = "/";

    public static List<String> splitBy(String src){
        if(src == null || src.length() == 0){
            return null;
        }
        List<String> resList = new ArrayList<>();
        int lastSplitPos = -1;
        for(int i = 0; i < src.length(); i++){
            String curStr = String.valueOf(src.charAt(i));
            if(SLANTING_BAR.equals(curStr) && i + 1 < src.length()){
                String nextStr = String.valueOf(src.charAt(i + 1));
                if(SLANTING_BAR.equals(nextStr) || DOT.equals(nextStr)){
                    src = src.substring(0, i) + src.substring(i + 1, src.length());
                }
            }else if(DOT.equals(curStr)){
                resList.add(src.substring(lastSplitPos + 1, i));
                lastSplitPos = i;
            }
        }
        resList.add(src.substring(lastSplitPos + 1, src.length()));
        return resList;
    }

    public static void splitBy(String src, List<String> resList){
        if(src == null || src.length() == 0){
            return;
        }
        boolean haveChild = false;
        for(int i = 0; i < src.length(); i++){
            String curStr = String.valueOf(src.charAt(i));
            if(SLANTING_BAR.equals(curStr) && i + 1 < src.length()){
                String nextStr = String.valueOf(src.charAt(i + 1));
                if(SLANTING_BAR.equals(nextStr) || DOT.equals(nextStr)){
                    src = src.substring(0, i) + src.substring(i + 1, src.length());
                }
            }else if(DOT.equals(curStr)){
                haveChild = true;
                resList.add(src.substring(0, i));
                splitBy(src.substring(i + 1, src.length()), resList);
                break;
            }
        }
        if(!haveChild){
            resList.add(src);
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String s = "1.";
//        String s = "1//.1";
//        String s = "1//.1/..1";
//        String s = "1//..1";
        splitBy(s, list);
//            for(String s1 : list){
//            System.out.println(s1);
//        }
//          String src = "1//..1.";
//          List<String> list = splitBy(src);
          for(String s1 : list){
              System.out.println(s1);
          }



//        String [] cs = StringDemo.delimitedListToStringArray(s, ".", "/");
//        for(String s0 : cs){
//            System.out.println(s0);
//        }
//        char[]  cs = new char[5];
//        cs[0] = 'a';
//        cs[1] = 'b';
//        cs[2] = 'c';
//        cs[3] = 'd';
//        String str = new String(cs, 1, 2);
//        System.out.println(str);
    }
}
