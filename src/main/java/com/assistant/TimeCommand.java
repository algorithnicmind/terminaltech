package com.assistant;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Command to display the current time.
 * Demonstrates use of Java Time API and string formatting with configurable format.
 */
public class TimeCommand extends Command {

    public TimeCommand() {
        super("time");
    }

    @Override
    public void execute(String[] args) throws Exception {
        LocalTime now = LocalTime.now();
        String format = Config.getProperty("time.format", "HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String timeString = now.format(formatter);
        System.out.println("Current time: " + timeString);
    }
}
