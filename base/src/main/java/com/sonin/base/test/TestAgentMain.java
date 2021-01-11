package com.sonin.base.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sonin
 * @date 2021/1/11 11:23
 */
@Slf4j
public class TestAgentMain {

    public static void main(String[] args) {
        String userId = "100001";
        queryUserAge(userId);
        queryUserName(userId);
    }

    private static void queryUserAge(String userId) {
        try {
            Thread.sleep(300);
            log.info("hello userId：" + userId + " age 18");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void queryUserName(String userId) {
        try {
            Thread.sleep(100);
            log.info("hello userId：" + userId + " name agent");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
