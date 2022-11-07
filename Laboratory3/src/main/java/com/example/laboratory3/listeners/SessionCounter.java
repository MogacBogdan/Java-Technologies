package com.example.laboratory3.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionCounter implements HttpSessionListener {
    private static int sessionCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        sessionCount++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        sessionCount--;
    }

    public static int getSessionCount() {
        return sessionCount;
    }
}
