package com.sonin.base.observer;

/**
 * @Author sonin
 * @Date 2020/9/27 6:27 下午
 * @Version 1.0
 **/
public class MainClient {
    public static void main(String[] args) {
        SubjectServiceImpl subjectService = new SubjectServiceImpl();
        StockObserver stockObserver = new StockObserver("adam", subjectService);
        subjectService.attach(stockObserver);
        subjectService.notifyObservers();

    }
}
