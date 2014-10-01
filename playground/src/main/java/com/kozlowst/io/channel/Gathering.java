package com.kozlowst.io.channel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by tomek on 10/1/14.
 */
public class Gathering {
    private FileOutputStream outputStream;
    private FileChannel channel;

    public static final byte[] h = {(byte)'a', 2, 3, 4};
    public static final byte[] b = {55, 66, 77};
    public static final byte[] f = {99};

    public Gathering(File file) throws FileNotFoundException {
        outputStream = new FileOutputStream(file, true);
        channel = outputStream.getChannel();
    }

    public void write() throws IOException {
        ByteBuffer header = ByteBuffer.allocate(5);
        ByteBuffer body = ByteBuffer.allocate(3);
        ByteBuffer footer = ByteBuffer.allocate(2);
        ByteBuffer[] byteBuffers = {header, body, footer};
        for (byte b1 : h) header.put(b1);
        for (byte b1 : b) body.put(b1);
        for (byte b1 : f) footer.put(b1);
        header.flip();
        body.flip();
        footer.flip();
        channel.write(byteBuffers);
    }

    public static void main(String[] args) {
        File file = new File("data/gathering" + System.currentTimeMillis() + ".txt");
        try {
            file.createNewFile();
            file.setWritable(true);
            Gathering gathering = new Gathering(file);
            gathering.write();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
