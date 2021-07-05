//package com.jw.myproject.myproject.test.zip;
//
//import net.lingala.zip4j.core.ZipFile;
//import net.lingala.zip4j.exception.ZipException;
//import net.lingala.zip4j.io.ZipOutputStream;
//import net.lingala.zip4j.model.ZipModel;
//import net.lingala.zip4j.model.ZipParameters;
//import net.lingala.zip4j.util.Zip4jConstants;
//import org.springframework.util.StringUtils;
//
//import java.io.*;
//import java.util.ArrayList;
//
//public class ZipTest {
//
//    public static void main(String[] args) {
//        File file = new File("C:\\Users\\tsign\\Desktop\\test.txt");
////        file.deleteOnExit();
//        File[] files = new File[] {file};
//        String dest = "C:\\Users\\tsign\\Desktop\\test.zip";
//        String password = "123456";
////        doZipFilesWithPassword(files, dest, password);
//        doZipStream(file,password);
//    }
//
//    /**
//     * 打包压缩包(带密码)
//     *
//     * @param srcfile 文件集合
//     * @param dest 带路径，带扩展名的压缩包名字
//     * @param password 压缩包密码
//     */
//    public static void doZipFilesWithPassword(File[] srcfile, String dest, String password) {
//
//        if (srcfile == null || srcfile.length == 0) {
//            return;
//        }
//
//        ZipParameters parameters = new ZipParameters();
//        // 压缩方式
//        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
//        // 压缩级别
//        parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
//        // 加密方式
//        if (!StringUtils.isEmpty(password)) {
//            parameters.setEncryptFiles(true);
//            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
//            parameters.setPassword(password);
//        }
//
//        ArrayList<File> existFileList = new ArrayList<File>();
//        for (int i = 0; i < srcfile.length; i++) {
//            if (srcfile[i] != null) {
//                existFileList.add(srcfile[i]);
//            }
//        }
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        try {
//            ZipFile zipFile = new ZipFile(dest);
//            zipFile.addFiles(existFileList, parameters);
//        } catch (ZipException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static ByteArrayOutputStream doZipStream(File file, String password) {
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//        try {
//            ByteArrayOutputStream fileBaos = new ByteArrayOutputStream();
//            InputStream inputStream = new FileInputStream(file);
//            byte[] b = new byte[1024];
//            int length = -1;
//            while ((length = inputStream.read(b)) != -1) {
//                fileBaos.write(b, 0, length);
//            }
//            inputStream.close();
//
//            ZipParameters parameters = new ZipParameters();
//            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
//            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
//            if (password != null) {
//                parameters.setEncryptFiles(true);
//                parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
//                parameters.setPassword(password);
//            }
//            parameters.setSourceExternalStream(true);
//            parameters.setFileNameInZip("compress.txt");
//            ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
//            zipOutputStream.putNextEntry(null,parameters);
//            zipOutputStream.write(fileBaos.toByteArray());
//            fileBaos.flush();
//            fileBaos.close();
//
//            zipOutputStream.flush();
//            zipOutputStream.closeEntry();
//            zipOutputStream.finish();
//            zipOutputStream.close();
//
//            outputStream.flush();
//
//            FileOutputStream fos = new FileOutputStream("C:\\Users\\tsign\\Desktop\\compre.txt");
//            outputStream.writeTo(fos);
//            outputStream.flush();
//            fos.flush();
//            fos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return outputStream;
//    }
//}
