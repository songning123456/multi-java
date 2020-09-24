package com.sonin.base.client;

import com.sonin.base.adapter.PowAdapter;

/**
 * @Author sonin
 * @Date 2020/9/24 6:53 下午
 * @Version 1.0
 **/
public class TestMain {
    public static void main(String[] args) {
        PowAdapter powAdapter = new PowAdapter();
        int res = powAdapter.output5V();
        System.out.println(res);
    }
}
