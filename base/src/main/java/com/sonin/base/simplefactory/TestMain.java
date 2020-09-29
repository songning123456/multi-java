package com.sonin.base.simplefactory;

/**
 * @Author sonin
 * @Date 2020/9/29 3:58 下午
 * @Version 1.0
 **/
public class TestMain {

    public static void main(String[] args) {
        VideoFactory videoFactory = new VideoFactory();
        Video javaVideo = videoFactory.getVideo(JavaVideo.class);
        Video pythonVideo = videoFactory.getVideo(PythonVideo.class);
        javaVideo.produce();
        pythonVideo.produce();
    }
}
