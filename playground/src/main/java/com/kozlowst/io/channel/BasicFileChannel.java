package com.kozlowst.io.channel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

import static com.kozlowst.io.Utils.*;

/**
 * Created by tomek on 10/1/14.
 */
public class BasicFileChannel {

    private RandomAccessFile accessFile;
    private FileChannel fileChannel;


    public BasicFileChannel(String fileName) throws FileNotFoundException {
        accessFile = new RandomAccessFile(fileName, "rw");
        fileChannel = accessFile.getChannel();
    }

    public void readBytes() throws IOException {
        ByteBuffer buff = ByteBuffer.allocate(4);
        int bytes;
        while ((bytes = fileChannel.read(buff)) != -1) {
            println(" -- Num of bytes: " + bytes);
            buff.flip();
            while(buff.hasRemaining()) print((char) buff.get());
            buff.clear();
        }
        accessFile.close();
    }

    public static void main(String[] args) {
        try {
            File file = new File("resources/sample.txt");
            println(file.getAbsolutePath());
            BasicFileChannel chnl = new BasicFileChannel("data/sample.txt");
            chnl.readBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }

        CharBuffer buff1 = CharBuffer.allocate(4);
        CharBuffer buff2 = CharBuffer.allocate(4);
        buff1.put('1');
        buff1.put('2');
        buff2.put('1');
        println("buff1 == buff2 >> " + buff1.compareTo(buff2));
        buff2.put('2');
        println("buff1 == buff2 >> " + buff1.compareTo(buff2));
        buff2.put('3');
        println("buff1 == buff2 >> " + buff1.compareTo(buff2));
    }

}
