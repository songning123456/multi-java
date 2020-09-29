package com.sonin.base.factorymethod;

/**
 * @Author sonin
 * @Date 2020/9/29 4:14 下午
 * @Version 1.0
 **/
public class JavaVideoFactory extends VideoFactory {

    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}
