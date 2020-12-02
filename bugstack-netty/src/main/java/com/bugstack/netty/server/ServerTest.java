package com.bugstack.netty.server;

/**
 * @author sonin
 * @date 2020/12/2 19:29
 */
public class ServerTest {
    public static void main(String[] args) throws Exception {
        int port = 1997;
        new EchoServer(port).start();
    }
}
