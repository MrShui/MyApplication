package com.shuiyouwen.myapplication;

/**
 * Created by Shui on 16/11/10.
 */

public class ClicksThrottle {
    private static long sLastTime;

    public static void click(long millis, Runnable runnable) {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - sLastTime) >= millis) {
            runnable.run();
        }
    }
}
