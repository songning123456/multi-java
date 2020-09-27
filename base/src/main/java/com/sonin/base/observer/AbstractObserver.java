package com.sonin.base.observer;

/**
 * @Author sonin
 * @Date 2020/9/24 7:13 下午
 * @Version 1.0
 **/
public abstract class AbstractObserver {

    public String name;

    public SubjectService subjectService;

    public AbstractObserver(String name, SubjectService subjectService) {
        this.name = name;
        this.subjectService = subjectService;
    }

    public abstract void update();
}
