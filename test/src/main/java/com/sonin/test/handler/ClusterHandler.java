package com.sonin.test.handler;

import com.alibaba.fastjson.JSONArray;
import com.sonin.test.dto.ClusterDTO;

import java.util.List;

/**
 * @author sonin
 * @date 2020/7/30 19:04
 */
public class ClusterHandler {

    public static void deploy(String deployInfo) {
        List<ClusterDTO> clusterDTOList = JSONArray.parseArray(deployInfo, ClusterDTO.class);
        System.out.println();
    }
}
