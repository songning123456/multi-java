package com.sonin.entity;

/**
 * @Author sonin
 * @Date 2021/1/6 8:49 下午
 * @Version 1.0
 **/
public class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
