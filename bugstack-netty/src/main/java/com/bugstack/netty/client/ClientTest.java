package com.bugstack.netty.client;

/**
 * @author sonin
 * @date 2020/12/2 19:27
 */
public class ClientTest {
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int port = 1997;
        new EchoClient(host, port).start();
    }
}
