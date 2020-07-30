package com.sonin.test.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by zhou.kan on 2020/4/6 0006.
 */
@Data
public class ClusterDTO {
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
    private LocalDateTime insertTime;
    private LocalDateTime updateTime;

    private String id;
    private String name;
    private String memory;
    private String status;
    private String description;
    private Integer serverGroupId;
//    private String host;
    private String cpu;
    private String os;
}
