package com.ricardo.springbootbase.threadlocal;

public class UserContent {

    private static ThreadLocal<User> threadLocal = new ThreadLocal<>();

    public static void set(User user) {
        threadLocal.set(user);
    }

    public static void remove() {
        threadLocal.remove();
    }

    public static User get() {
        return threadLocal.get();
    }
}
