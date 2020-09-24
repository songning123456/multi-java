package com.sonin.base.adapter;

/**
 * @Author sonin
 * @Date 2020/9/24 6:05 下午
 * @Version 1.0
 **/
public class TwoToThreeAdapter implements ThreePower {

    private TwoPower twoPower;

    public TwoToThreeAdapter(TwoPower twoPower) {
        this.twoPower = twoPower;
    }

    @Override
    public void powerByThree() {
        System.out.println("adapter");
        twoPower.powerByTwo();
    }
}
