package com.kozlowst.io.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import static com.kozlowst.io.Utils.*;

/**
 * Created by tomek on 10/1/14.
 */
public class Scattering {

    private FileInputStream fileInputStream;
    private FileChannel fileChannel;

    public Scattering(String fileName) throws FileNotFoundException {
        fileInputStream = new FileInputStream(new File(fileName));
        fileChannel = fileInputStream.getChannel();
    }

    public void read() throws IOException {
        ByteBuffer header = ByteBuffer.allocate(10); // 9 chars + 1 EOL
        ByteBuffer body = ByteBuffer.allocate(8);
        ByteBuffer footer = ByteBuffer.allocate(3);
        ByteBuffer[] byteBuffers = {header, body, footer};
        long bytes = fileChannel.read(byteBuffers);
        println("Bytes: " + bytes);

        header.flip();
        println("Header");
        while (header.hasRemaining()) print((char) header.get());

        body.flip();
        println("Body");
        while (body.hasRemaining()) print((char) body.get());

        footer.flip();
        println("Footer");
        while (footer.hasRemaining()) print((char) footer.get());
    }

    public static void main(String[] args) {
        try {
            Scattering scattering = new Scattering("data/scattering.txt");
            scattering.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
