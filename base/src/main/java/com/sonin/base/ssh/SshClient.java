package com.sonin.base.ssh;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;

/**
 * 已经修改过alone sentinel cluster配置文件基本配置
 *
 * @author sonin
 * @date 2020/8/8 9:18
 */
public class SshClient {

    public void execAlone(String userName, String password, String host, String port) {
        Connection connection = null;
        Session session = null;
        try {
            connection = new Connection(host);
            connection.connect();
            boolean isAuthenticated = connection.authenticateWithPassword(userName, password);
            if (!isAuthenticated) {
                throw new Exception("isAuthenticated fail!");
            }
            session = connection.openSession();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("if [ ! -d '/home/sonin/Documents/deployredis/alone' ]; then\n");
            stringBuilder.append(" mkdir /home/sonin/Documents/deployredis/alone\n");
            stringBuilder.append("fi");
            stringBuilder.append(" && ");
            stringBuilder.append("cp /home/sonin/Documents/deployredis/base/redis-alone.conf /home/sonin/Documents/deployredis/alone/redis-alone.conf.").append(port);
            stringBuilder.append(" && ");
            stringBuilder.append("sed -i 's/6379/").append(port).append("/' /home/sonin/Documents/deployredis/alone/redis-alone.conf.").append(port);
            stringBuilder.append(" && ");
            stringBuilder.append("/home/sonin/Documents/deployredis/base/redis-server /home/sonin/Documents/deployredis/alone/redis-alone.conf.").append(port);
            session.execCommand(stringBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
