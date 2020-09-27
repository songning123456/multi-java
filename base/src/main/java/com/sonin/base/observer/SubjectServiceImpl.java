package com.sonin.base.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author sonin
 * @Date 2020/9/27 6:19 下午
 * @Version 1.0
 **/
public class SubjectServiceImpl implements SubjectService {

    private final List<AbstractObserver> observers = new LinkedList<>();
    private String action;

    @Override
    public void attach(AbstractObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(AbstractObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (AbstractObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String getAction() {
        return action;
    }
}
