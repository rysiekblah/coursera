package com.kozlowst.io.udp;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Created by tomek on 10/18/14.
 */
public class Server {

    public static final int PORT = 6666;
    public static final String HOST = "127.0.0.1";
    public static final int BUFF_SIZE = 4 * 1024;

    public static void main(String[] args) {
        Server server = new Server();
        try(DatagramChannel datagramChannel = DatagramChannel.open(StandardProtocolFamily.INET)) {

            if (datagramChannel.isOpen()) {
                datagramChannel.setOption(StandardSocketOptions.SO_RCVBUF, BUFF_SIZE);
                datagramChannel.setOption(StandardSocketOptions.SO_SNDBUF, BUFF_SIZE);
                datagramChannel.bind(new InetSocketAddress(HOST, PORT));
                server.displayAddresses(datagramChannel);
                server.displayOptions(datagramChannel);

                ByteBuffer buffer = ByteBuffer.allocate(65507);
                System.out.println("Server started");
                while (true) {
                    SocketAddress clientAddress = datagramChannel.receive(buffer);
                    buffer.flip();
                    System.out.println("Received: " + buffer.limit() + " bytes from " + clientAddress.toString());
                    datagramChannel.send(buffer, clientAddress);
                    buffer.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayOptions(DatagramChannel channel) {
        for (SocketOption<?> socketOption : channel.supportedOptions()) {
            System.out.println(socketOption);
        }
    }

    private void displayAddresses(DatagramChannel channel) throws IOException {
        System.out.println("Local IP  : " + channel.getLocalAddress());
        System.out.println("Remote IP : " + channel.getRemoteAddress());
    }

}
