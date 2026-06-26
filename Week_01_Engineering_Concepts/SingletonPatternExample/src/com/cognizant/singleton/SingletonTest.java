package com.cognizant.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        // Attempt to capture multiple instances
        Logger instanceA = Logger.getInstance();
        Logger instanceB = Logger.getInstance();

        instanceA.log("Initializing local application execution parameters...");
        instanceB.log("Processing batch execution tracking indexes...");

        System.out.println("\n--- Evaluation Verification Console Output ---");
        System.out.println("Memory Address Reference Instance A HashCode: " + instanceA.hashCode());
        System.out.println("Memory Address Reference Instance B HashCode: " + instanceB.hashCode());

        if (instanceA == instanceB) {
            System.out.println("✔ SUCCESS RESULT: Both references match perfectly. Singleton pattern verified.");
        } else {
            System.out.println("❌ ERROR: Violation detected. Separate instances exist in heap memory.");
        }
    }
}