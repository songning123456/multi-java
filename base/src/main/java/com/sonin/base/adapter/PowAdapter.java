package com.sonin.base.adapter;

/**
 * @Author sonin
 * @Date 2020/9/24 6:39 下午
 * @Version 1.0
 **/
public class PowAdapter extends PowerSource implements PowerTarget {

    @Override
    public int output5V() {
        int output = output220();
        output /= 44;
        return output;
    }
}
