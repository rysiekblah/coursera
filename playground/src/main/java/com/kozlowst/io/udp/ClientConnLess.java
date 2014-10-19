package com.kozlowst.io.udp;

import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by tomek on 10/18/14.
 */
public class ClientConnLess {
    public static void main(String[] args) {
        final int PORT = 6666;
        final String HOST = "127.0.0.1";
        final int BUFF_SIZE = 65507;

        CharBuffer charbuffer = null;
        Charset charset = Charset.defaultCharset();
        CharsetDecoder decoder = charset.newDecoder();
        ByteBuffer msgToSrv = ByteBuffer.wrap("Hey dude".getBytes());
        ByteBuffer buffer = ByteBuffer.allocate(BUFF_SIZE);

        try (DatagramChannel datagramChannel = DatagramChannel.open(StandardProtocolFamily.INET)) {
            if (datagramChannel.isOpen()) {
                datagramChannel.setOption(StandardSocketOptions.SO_RCVBUF, 4 * 1024);
                datagramChannel.setOption(StandardSocketOptions.SO_SNDBUF, 4 * 1024);

                int sent = datagramChannel.send(msgToSrv, new InetSocketAddress(HOST, PORT));
                datagramChannel.receive(buffer);
                buffer.flip();
                charbuffer = decoder.decode(buffer);
                System.out.println("Client received: " + charbuffer.toString());
                buffer.clear();
            }
        } catch (Exception e) {

        }
    }
}
