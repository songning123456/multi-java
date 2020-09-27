package com.sonin.base.observer;

import java.util.Observer;

/**
 * @Author sonin
 * @Date 2020/9/27 6:24 下午
 * @Version 1.0
 **/
public class StockObserver extends AbstractObserver {

    public StockObserver(String name, SubjectService subjectService) {
        super(name, subjectService);
    }

    @Override
    public void update() {
        System.out.println(subjectService.getAction() + "\n" + name);
    }
}
