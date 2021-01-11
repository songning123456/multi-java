package com.javaagent.learn;

import java.util.Stack;

/**
 * @author sonin
 * @date 2021/1/11 15:51
 */
public class TrackManager {

    private static final ThreadLocal<Stack<String>> TRACK = new ThreadLocal<>();

    private static String createSpan() {
        Stack<String> stack = TRACK.get();
        if (stack == null) {
            stack = new Stack<>();
            TRACK.set(stack);
        }
        String linkId;
        if (stack.isEmpty()) {
            linkId = TrackContext.getLinkId();
            if (linkId == null) {
                linkId = "nvl";
                TrackContext.setLinkId(linkId);
            }
        } else {
            linkId = stack.peek();
            TrackContext.setLinkId(linkId);
        }
        return linkId;
    }

    public static String createEntrySpan() {
        String span = createSpan();
        Stack<String> stack = TRACK.get();
        stack.push(span);
        return span;
    }

    public static String getExitSpan() {
        Stack<String> stack = TRACK.get();
        if (stack == null || stack.isEmpty()) {
            TrackContext.clear();
            return null;
        }
        return stack.pop();
    }

    public static String getCurrentSpan() {
        Stack<String> stack = TRACK.get();
        if (stack == null || stack.isEmpty()) {
            return null;
        }
        return stack.peek();
    }

}
