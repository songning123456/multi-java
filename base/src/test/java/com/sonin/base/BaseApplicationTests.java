package com.sonin.base;

import com.sonin.base.ssh.SshClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BaseApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("test OK");
    }

    @Test
    public void testDeployRedis() {
        String userName = "sonin";
        String password = "772805406sn123.";
        String host = "192.168.88.128";
        String port = "6400";
        new SshClient().execAlone(userName, password, host, port);
    }

}
