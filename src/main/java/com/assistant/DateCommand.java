package com.assistant;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Command to display the current date.
 * Demonstrates use of Java Time API and string formatting with configurable format.
 */
public class DateCommand extends Command {

    public DateCommand() {
        super("date");
    }

    @Override
    public void execute(String[] args) throws Exception {
        LocalDate today = LocalDate.now();
        String format = Config.getProperty("date.format", "yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String dateString = today.format(formatter);
        System.out.println("Current date: " + dateString);
    }
}
