package org.autumn.revolution.j2se.demo.file;

import java.io.*;

/**
 * Created by yangzhichao on 15/10/16.
 */
public class Processor {

    public static void main(String[] args) throws Exception{
        File file = new File("/Users/yangzhichao/git/octopus/octopus/src/main/java/com/unfae/octopus/constant/OctopusError.java");

        StringBuffer sb = new StringBuffer();
        InputStream is = new FileInputStream(file);
        InputStreamReader fr = new InputStreamReader(is,"utf-8");
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        while((line=br.readLine())!=null){
            if(line.indexOf("//")>0){
                System.out.println(line.indexOf("//"));
                //int p1 = line.indexOf("ErrorCode");
                //int p2 = line.indexOf(".name");
                //line = line.replaceAll(".name",".getCode");

            }
            sb.append(line);
            sb.append("\n");
            System.out.println(line);
        }
        is.close();

        // 写回文件

        OutputStream os = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(os,"utf-8");
        BufferedWriter bw = new BufferedWriter(osw);
        //bw.write("");
        //bw.write(sb.toString());
        bw.flush();
        os.close();





    }
}
