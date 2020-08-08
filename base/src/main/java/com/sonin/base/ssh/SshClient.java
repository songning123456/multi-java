package com.sonin.base.ssh;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import com.sonin.base.entity.RedisNode;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        Connection connection = null;
        Session session = null;
        int totalNum = masterNum * (replicaNum + 1);
        try {
            connection = new Connection(host, 22);
            connection.connect();
            connection.authenticateWithPassword(userName, password);
            session = connection.openSession();
            StringBuilder stringBuilder;
            for (int i = 0; i < totalNum; i++) {
                int port = startPort + i;
                stringBuilder = new StringBuilder();
                session = connection.openSession();
                stringBuilder.append("cp /home/sonin/Documents/deployredis/base/redis-cluster.conf /home/sonin/Documents/deployredis/cluster/redis.conf.").append(port);
                stringBuilder.append(" && ");
                stringBuilder.append("sed -i 's/6379/").append(port).append("/' /home/sonin/Documents/deployredis/cluster/redis.conf.").append(port);
                stringBuilder.append(" && ");
                stringBuilder.append("/home/sonin/Documents/deployredis/base/redis-server /home/sonin/Documents/deployredis/cluster/redis.conf.").append(port);
                session.execCommand(stringBuilder.toString());
                Thread.sleep(5000);
                session.close();
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
        // /home/sonin/Documents/deployredis/base/redis-cli --cluster create 127.0.0.1:6670 127.0.0.1:6671 127.0.0.1:6672 127.0.0.1:6673 127.0.0.1:6674  127.0.0.1:6675 --cluster-replicas 1

        /*for (int i = 0; i < totalNum; i++) {
            int curPort = startPort + i;
            if (i != 0) {
                Jedis jedis = new Jedis(host, startPort);
                jedis.clusterMeet(host, curPort);
                jedis.close();
            }
        }
        try {
            Thread.sleep(2000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //节点replica
            List<RedisNode> nodes = clusterNodes(host, startPort);
            //选择master
            List<RedisNode> masterNodes = nodes.stream().limit(masterNum).collect(Collectors.toList());
            List<String> masterIds = masterNodes.stream().map(RedisNode::getNodeId).collect(Collectors.toList());
            //选择所有的slave节点
            List<RedisNode> slaveNodes = nodes.stream().filter(slaveNode -> !masterIds.contains(slaveNode.getNodeId())).collect(Collectors.toList());
            int masterIndex = 0;
            int count = replicaNum;
            for (RedisNode slaveNode : slaveNodes) {
                if (count == 0) {
                    masterIndex++;
                    count = replicaNum;
                }
                String masterId = masterIds.get(masterIndex);
                slaveNode.setMasterId(masterId);
                count--;
            }
            slaveNodes.stream().filter(redisNode -> redisNode.getMasterId() != null).forEach(redisNode -> {
                Jedis jedis = new Jedis(redisNode.getHost(), redisNode.getPort());
                jedis.clusterReplicate(redisNode.getMasterId());
                jedis.close();
            });
            //节点slot
            int slotOffset = 16384 / masterNum;
            int start = 0;
            for (RedisNode masterNode : masterNodes) {
                if (start + slotOffset * 2 > 16384) {
                    masterNode.setEndSlot(16383);
                } else {
                    masterNode.setEndSlot(start + slotOffset);
                }
                masterNode.setStartSlot(start);
                start = start + slotOffset + 1;
            }

            masterNodes.forEach(masterNode -> {
                Jedis jedis = new Jedis(masterNode.getHost(), masterNode.getPort());
                int startSlot = masterNode.getStartSlot();
                int end = masterNode.getEndSlot();
                int[] slots = new int[end - startSlot + 1];
                for (int i = startSlot, j = 0; i <= end; i++, j++) {
                    slots[j] = i;
                }
                jedis.clusterAddSlots(slots);
                jedis.close();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    private List<RedisNode> clusterNodes(String host, int port) throws Exception {
        Jedis jedis = new Jedis(host, port);
        String nodes = jedis.clusterNodes();
        System.out.println(nodes);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(nodes.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8));
        String line;
        List<RedisNode> redisNodeList = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] item = line.split(" ");
            String nodeId = item[0].trim();
            String ipPort = item[1];
            //noaddr 可知有此标记的节点属于无用节点
            if (line.contains("noaddr")) {
                continue;
            }
            Set<HostAndPort> hostAndPortSet = this.nodesToHostAndPortSet(ipPort.split("@")[0]);
            HostAndPort hostAndPort = hostAndPortSet.iterator().next();
            String flags = item[2];
            String masterId = item[3];
            String linkState = item[7];
            RedisNode redisNode = new RedisNode(nodeId, hostAndPort.getHost(), hostAndPort.getPort());
            if (flags.contains("myself")) {
                flags = flags.substring(7);
            }
            redisNode.setFlags(flags);
            redisNode.setMasterId(masterId);
            redisNode.setLinkState(linkState);
            int length = item.length;
            if (length > 8) {
                int slotNumber = 0;
                StringBuilder slotRang = new StringBuilder();
                for (int i = 8; i < length; i++) {
                    String slotRangeItem = item[i];
                    String[] startAndEnd = slotRangeItem.split("-");
                    if (startAndEnd.length == 1) {
                        slotNumber += 1;
                    } else {
                        slotNumber += Integer.parseInt(startAndEnd[1]) - Integer.parseInt(startAndEnd[0]) + 1;
                    }
                    slotRang.append(slotRangeItem);
                    if (i < length - 1) {
                        slotRang.append(",");
                    }
                }
                redisNode.setSlotRange(slotRang.toString());
                redisNode.setSlotNumber(slotNumber);
            }

            redisNodeList.add(redisNode);
        }
        return redisNodeList;
    }

    private Set<HostAndPort> nodesToHostAndPortSet(String nodes) {
        String[] nodeList = nodes.split(",");
        int length = nodeList.length;
        Set<HostAndPort> hostAndPortSet = new HashSet<>(length);
        if (length > 0) {
            for (String node : nodeList) {
                String[] ipAndPort = node.split(":");
                HostAndPort hostAndPort = new HostAndPort(ipAndPort[0], Integer.parseInt(ipAndPort[1]));
                hostAndPortSet.add(hostAndPort);
            }
        }
        return hostAndPortSet;
    }
}
