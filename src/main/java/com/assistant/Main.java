package com.assistant;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Main class for the Assistant application.
 * Handles user input loop, command parsing, execution queue, history, and graceful shutdown.
 * Demonstrates OOP, exception handling, string manipulation, collections, multithreading, and synchronization.
 */
public class Main {
    private static Map<String, Command> commands = new HashMap<>();
    private static List<String> history = new ArrayList<>();
    private static BlockingQueue<String> commandQueue = new LinkedBlockingQueue<>();
    private static ExecutorService executor = Executors.newSingleThreadExecutor();
    private static boolean running = true;

    static {
        // Register commands
        commands.put("hello", new GreetCommand());
        commands.put("time", new TimeCommand());
        commands.put("date", new DateCommand());
        commands.put("calculate", new CalculatorCommand());
        commands.put("reminder", new ReminderCommand());
        commands.put("help", new HelpCommand());
        commands.put("history", new HistoryCommand(history));
        commands.put("open", new OpenAppCommand());
        commands.put("file", new FileCommand());
        commands.put("system", new SystemCommand());

        // Aliases
        commands.put("clock", new TimeCommand());
        commands.put("today", new DateCommand());
        commands.put("calc", new CalculatorCommand());
    }

    private static String currentUser = null;

    public static void main(String[] args) {
        Logger.log("Assistant started");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Assistant!");
        System.out.print("Enter username to login: ");
        String username = scanner.nextLine().trim();

        if (!username.equals("ankit94")) {
            System.out.println("Error: Invalid username. Access denied.");
            Logger.log("Failed login attempt with username: " + username);
            scanner.close();
            return;
        }

        currentUser = username;
        System.out.println("Logged in as: " + currentUser);
        Logger.log("User logged in: " + currentUser);

        // Start command processor thread
        executor.submit(() -> {
            while (running) {
                try {
                    String input = commandQueue.take();
                    processCommand(input);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                    Logger.log("Error processing command: " + e.getMessage());
                }
            }
        });

        System.out.println("Type 'help' for commands or 'exit' to quit.");

        while (running) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                running = false;
                break;
            }

            try {
                commandQueue.put(input);  // Add to queue for processing
                history.add(input);  // Add to history
                int maxHistory = Integer.parseInt(Config.getProperty("history.size", "10"));
                if (history.size() > maxHistory) {
                    history.remove(0);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Graceful shutdown
        executor.shutdown();
        ReminderCommand.scheduler.shutdown();  // Shutdown reminder scheduler
        Logger.log("Assistant shut down");
        System.out.println("Goodbye!");
        scanner.close();
    }

    private static void processCommand(String input) throws Exception {
        String[] parts = input.split("\\s+", 2);  // Split into command and args
        String cmd = parts[0].toLowerCase();
        String[] cmdArgs = parts.length > 1 ? parts[1].split("\\s+") : new String[0];

        Command command = commands.get(cmd);
        if (command == null) {
            throw new InvalidCommandException("Unknown command: " + cmd);
        }

        command.execute(cmdArgs);
        Logger.log("Executed command: " + input);
    }
}
