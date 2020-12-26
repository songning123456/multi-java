package com.sonin.secondview;

import java.util.*;

/**
 * @Author sonin
 * @Date 2020/12/26 5:53 下午
 * @Version 1.0
 **/
public class Twitter {

    private static int timestamp = 0;

    private static class Tweet {
        private int id;
        private int time;
        private Tweet next;

        public Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    private static class User {
        private int id;
        public Set<Integer> followed;
        public Tweet head;

        public User(int userId) {
            followed = new HashSet<>();
            this.id = userId;
            this.head = null;
            follow(id);
        }

        private void follow(int userId) {
            followed.add(userId);
        }

        private void unfollow(int userId) {
            if (userId != this.id) {
                followed.remove(userId);
            }
        }

        private void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId, timestamp);
            timestamp++;
            tweet.next = head;
            head = tweet;
        }
    }

    private final Map<Integer, User> userMap = new HashMap<>(2);

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        User user = userMap.get(userId);
        user.post(tweetId);
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User user = new User(followerId);
            userMap.put(followerId, user);
        }
        if (!userMap.containsKey(followeeId)) {
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            User user = userMap.get(followerId);
            user.unfollow(followeeId);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return res;
        }
        Set<Integer> userIds = userMap.get(userId).followed;
        PriorityQueue<Tweet> priorityQueue = new PriorityQueue<>(userIds.size(), (a, b) -> (b.time - a.time));
        for (int id : userIds) {
            Tweet tweet = userMap.get(id).head;
            if (tweet == null) {
                continue;
            }
            priorityQueue.add(tweet);
        }
        while (!priorityQueue.isEmpty()) {
            if (res.size() == 10) {
                break;
            }
            Tweet tweet = priorityQueue.poll();
            res.add(tweet.id);
            if (tweet.next != null) {
                priorityQueue.add(tweet.next);
            }
        }
        return res;
    }
}
