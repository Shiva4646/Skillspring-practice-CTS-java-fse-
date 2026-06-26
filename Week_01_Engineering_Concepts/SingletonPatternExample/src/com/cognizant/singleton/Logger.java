package com.cognizant.singleton;

public class Logger {
    // 1. Private static variable to hold the unique instance
    private static volatile Logger instance;

    // 2. Private constructor prevents direct object creation via 'new' from outside
    private Logger() {
        // Guard against instantiation via the Java Reflection API
        if (instance != null) {
            throw new RuntimeException("Violation Warning: Use getInstance() instead!");
        }
    }

    // 3. Global access point to return the identical unique reference
    public static Logger getInstance() {
        if (instance == null) { // Check 1: No synchronization overhead if initialized
            synchronized (Logger.class) {
                if (instance == null) { // Check 2: Thread-safe initialization safety
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[APPLICATION LOG] " + message);
    }
}