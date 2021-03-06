package com.sonin.base.observer;

/**
 * @Author sonin
 * @Date 2020/9/24 7:13 下午
 * @Version 1.0
 **/
public interface SubjectService {
    void attach(AbstractObserver observer);

    void detach(AbstractObserver observer);

    void notifyObservers();

    void setAction(String action);

    String getAction();
}
