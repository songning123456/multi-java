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

    public void execAlone(String userName, String password, String host, Integer port) {
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
            stringBuilder.append("cp /home/sonin/Documents/deployredis/base/redis-alone.conf /home/sonin/Documents/deployredis/alone/redis.conf.").append(port);
            stringBuilder.append(" && ");
            stringBuilder.append("sed -i 's/6379/").append(port).append("/' /home/sonin/Documents/deployredis/alone/redis.conf.").append(port);
            stringBuilder.append(" && ");
            stringBuilder.append("/home/sonin/Documents/deployredis/base/redis-server /home/sonin/Documents/deployredis/alone/redis.conf.").append(port);
            session.execCommand(stringBuilder.toString());
            Thread.sleep(2000);
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

    public void execSentinel(String userName, String password, String host, Integer startPort, Integer slaveNum) {
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
            stringBuilder.append("if [ ! -d '/home/sonin/Documents/deployredis/sentinel' ]; then\n");
            stringBuilder.append(" mkdir /home/sonin/Documents/deployredis/sentinel\n");
            stringBuilder.append("fi");
            session.execCommand(stringBuilder.toString());
            Thread.sleep(2000);
            session.close();
            for (int i = 0; i <= slaveNum; i++) {
                stringBuilder = new StringBuilder();
                session = connection.openSession();
                int curPort = startPort + i;
                stringBuilder.append("cp /home/sonin/Documents/deployredis/base/redis-sentinel.conf /home/sonin/Documents/deployredis/sentinel/redis.conf.").append(curPort);
                stringBuilder.append(" && ");
                stringBuilder.append("sed -i 's/6379/").append(curPort).append("/' /home/sonin/Documents/deployredis/sentinel/redis.conf.").append(curPort);
                if (i != 0) {
                    stringBuilder.append(" && ");
                    stringBuilder.append("sed -i 's/# slaveof <masterip> <masterport>/slaveof ").append(host).append(" ").append(startPort).append("/' /home/sonin/Documents/deployredis/sentinel/redis.conf.").append(curPort);
                }
                stringBuilder.append(" && ");
                stringBuilder.append("/home/sonin/Documents/deployredis/base/redis-server /home/sonin/Documents/deployredis/sentinel/redis.conf.").append(curPort);
                session.execCommand(stringBuilder.toString());
                Thread.sleep(2000);
                session.close();
            }
            int sentinelPort = startPort + slaveNum + 1;
            for (int i = 0; i <= slaveNum; i++) {
                stringBuilder = new StringBuilder();
                session = connection.openSession();
                stringBuilder.append("cp /home/sonin/Documents/deployredis/base/sentinel.conf /home/sonin/Documents/deployredis/sentinel/sentinel.conf.").append(sentinelPort);
                stringBuilder.append(" && ");
                stringBuilder.append("sed -i 's/26379/").append(sentinelPort).append("/' /home/sonin/Documents/deployredis/sentinel/sentinel.conf.").append(sentinelPort);
                stringBuilder.append(" && ");
                stringBuilder.append("sed -i 's/sentinel monitor mymaster 127.0.0.1 6379 2/sentinel monitor mymaster ").append(host).append(" ").append(startPort).append(" 2/' /home/sonin/Documents/deployredis/sentinel/sentinel.conf.").append(sentinelPort);
                stringBuilder.append(" && ");
                stringBuilder.append("/home/sonin/Documents/deployredis/base/redis-sentinel /home/sonin/Documents/deployredis/sentinel/sentinel.conf.").append(sentinelPort);
                session.execCommand(stringBuilder.toString());
                Thread.sleep(2000);
                session.close();
                sentinelPort++;
            }
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

    public void execCluster(String userName, String password, String host, int startPort, int masterNum, int replicaNum) {

    }
}
