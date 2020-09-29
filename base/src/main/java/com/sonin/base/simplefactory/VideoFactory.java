package com.sonin.base.simplefactory;

/**
 * @Author sonin
 * @Date 2020/9/29 3:56 下午
 * @Version 1.0
 **/
public class VideoFactory {

    public Video getVideo(Class clazz) {
        Video video = null;
        try {
            video = (Video) Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return video;
    }
}
