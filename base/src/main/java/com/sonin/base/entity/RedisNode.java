package com.sonin.base.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sonin
 * @date 2020/8/8 11:41
 */
@Data
public class RedisNode implements Serializable {

    private static final long serialVersionUID = 1L;

    public RedisNode(String nodeId, String host, int port) {
        this.nodeId = nodeId;
        this.host = host;
        this.port = port;
    }

    private Integer redisNodeId;
    private Integer groupId;
    private String clusterId;
    private String nodeId;
    private String masterId;
    private String host;
    private Integer port;
    private String nodeRole;
    private String flags;
    private String linkState;
    private String slotRange;
    private Integer slotNumber;
    private String containerId;
    private String containerName;
    private Integer startSlot;
    private Integer endSlot;
}
