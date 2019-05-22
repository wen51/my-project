package com.jw.myproject.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class NIOTest {

    public static void main(String[] args) {
//        intBufferTest();
        readFileTest();
    }

    /**
     * 使用NIO读取文件
     */
    private static void readFileTest(){
        FileInputStream fileInputStream = null;
        try {
            //1、获取channel
            fileInputStream = new FileInputStream("C:\\Users\\wen\\Desktop\\加油\\面试经过.txt");
            FileChannel fileChannel = fileInputStream.getChannel();

            //2、生产buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //3、将数据从channel读取到buffer
            fileChannel.read(buffer);

            buffer.flip();

            while (buffer.hasRemaining()) {
                byte b= buffer.get();
                System.out.println((char) b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
    private static void intBufferTest() {
        IntBuffer buffer = IntBuffer.allocate(8);

        for(int i = 0; i<buffer.capacity(); i++){
            int j = 2 * (i +1);
            buffer.put(j);

        }
        buffer.flip();
        while (buffer.hasRemaining()){
            int j = buffer.get();
            System.out.print(j + "   ");
        }
    }
}
