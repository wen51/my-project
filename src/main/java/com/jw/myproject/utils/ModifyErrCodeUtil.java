package com.jw.myproject.utils;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModifyErrCodeUtil {

    private static final String reg = "";

    /**
     * 错误码修改
     * @param path
     * @param fileDestination
     * @param startCode
     */
    public static void modifyErrCode(String path, String fileDestination, int startCode) {
        File file = new File(path);
        if (file.isFile() && file.exists()) {
            OutputStreamWriter osw = null;
            BufferedWriter writer = null;
            InputStreamReader isr = null;
            BufferedReader br = null;
            try {
                osw = new OutputStreamWriter(new FileOutputStream(new File(fileDestination)));
                writer = new BufferedWriter(osw);
                isr = new InputStreamReader(new FileInputStream(file), "utf-8");
                br = new BufferedReader(isr);
                String lineText = null;

                while ((lineText = br.readLine()) != null) {
                    Matcher matcher = Pattern.compile("\\d+").matcher(lineText);
                    if(matcher.find()){
                        String oldStr = lineText.substring(matcher.start(), matcher.end());
                        if(!matcher.find() && Integer.valueOf(oldStr).intValue() > 10000){
                            lineText = lineText.replace(oldStr, startCode+"");

                            startCode++;
                        }
                    }
                    writer.write(lineText);
                    writer.newLine();
                }
                writer.flush();

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally{
                try {
                    if(osw != null){
                        osw.close();
                    }
                    if(isr != null){
                        isr.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(1123);
            }
        }
    }

    public static void main(String[] args) {
        modifyErrCode("C:\\Users\\tsign\\Desktop\\SignFlowErrorEnum.java","C:\\Users\\tsign\\Desktop\\test.java", 20050001);
//        String lineText = "asdf23asdfas";
//        int startCode = 99999;
//        Matcher matcher = Pattern.compile("\\d+").matcher(lineText);
//        if(matcher.find()){
//            String oldStr = lineText.substring(matcher.start(), matcher.end());
//            if(Integer.valueOf(oldStr).intValue() > 10000){
//                lineText = lineText.replace(oldStr, startCode+"");
//
//                startCode++;
//            }
//        }
//
//        System.out.println(lineText);
    }
}
