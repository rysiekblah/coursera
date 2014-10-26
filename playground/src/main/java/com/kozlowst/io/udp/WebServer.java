package com.kozlowst.io.udp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by tomek on 10/18/14.
 */
public class WebServer extends Thread {

    private final int PORT = 9000;

    private String serverText = null;
    private ServerSocket serverSocket = null;

    public WebServer(String text) {
        this.serverText = text;
    }

    @Override
    public void run() {
        System.out.println("Starting server ... ");
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                InputStream input = clientSocket.getInputStream();
                OutputStream output = clientSocket.getOutputStream();
                long time = System.currentTimeMillis();
//                output.write(("HTTP/1.1 200 OK\n\nWorkerRunnable: " +
//                        this.serverText + " - " +
//                        time +
//                        "").getBytes());
                output.write(createHttp().getBytes());
                output.close();
                input.close();
                System.out.println("Request processed: " + time);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private String createHttp() {
        StringBuffer buffer = new StringBuffer();
        long time = System.currentTimeMillis();
        buffer.append("HTTP/1.1 200 OK\n\n");
        buffer.append("<html>");
        buffer.append("<head><title>HTML Reference</title><meta http-equiv=\"Refresh\" content=\"1\" /></head>");
        buffer.append("<body>");
        buffer.append("<html><b>Hello</b> there " + time + " </html>");
        buffer.append("</body></html>");
        return buffer.toString();
    }

    private void openServerSocket() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server open: " + serverSocket.getInetAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WebServer server = new WebServer("hello");
        server.openServerSocket();
        server.start();
    }

}
