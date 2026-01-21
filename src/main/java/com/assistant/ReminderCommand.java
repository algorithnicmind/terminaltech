package com.assistant;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Command to set a reminder.
 * Demonstrates multithreading using ScheduledExecutorService for timer-based reminders.
 */
public class ReminderCommand extends Command {

    public static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);

    public ReminderCommand() {
        super("reminder");
    }

    @Override
    public void execute(String[] args) throws Exception {
        if (args.length < 2) {
            throw new InvalidCommandException("Usage: reminder <seconds> <message>");
        }

        try {
            int seconds = Integer.parseInt(args[0]);
            StringBuilder message = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                message.append(args[i]).append(" ");
            }
            String reminderMessage = message.toString().trim();

            // Schedule the reminder
            scheduler.schedule(() -> {
                System.out.println("\nReminder: " + reminderMessage);
                System.out.print("Enter command: ");
            }, seconds, TimeUnit.SECONDS);

            System.out.println("Reminder set for " + seconds + " seconds: " + reminderMessage);
        } catch (NumberFormatException e) {
            throw new InvalidCommandException("Invalid number of seconds");
        }
    }
}
