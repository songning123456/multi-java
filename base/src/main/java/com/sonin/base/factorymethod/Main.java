package com.sonin.base.factorymethod;

/**
 * @Author sonin
 * @Date 2020/9/29 4:19 下午
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) {
        VideoFactory videoFactory = new JavaVideoFactory();
        Video javaVideo = videoFactory.getVideo();
        javaVideo.produce();
    }
}
