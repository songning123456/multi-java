package com.sonin.base.simplefactory;

/**
 * @Author sonin
 * @Date 2020/9/29 3:54 下午
 * @Version 1.0
 **/
public class JavaVideo extends Video {

    @Override
    public void produce() {
        System.out.println("录制Java视频");
    }
}
