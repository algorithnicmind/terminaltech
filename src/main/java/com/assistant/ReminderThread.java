package com.assistant;

/**
 * Thread class to handle reminders in the background.
 * Demonstrates multithreading concepts.
 */
public class ReminderThread extends Thread {
    private int seconds;
    private String message;

    public ReminderThread(int seconds, String message) {
        this.seconds = seconds;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(seconds * 1000L); // Sleep for the specified seconds
            System.out.println("\nReminder: " + message);
            System.out.print("Enter command: "); // Reprompt after reminder
        } catch (InterruptedException e) {
            System.out.println("Reminder interrupted.");
        }
    }
}
