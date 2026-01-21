package com.assistant;

import java.io.IOException;
import java.util.Scanner;

/**
 * Command to handle system operations: shutdown, restart, sleep.
 * Demonstrates system interaction and user confirmation.
 */
public class SystemCommand extends Command {

    public SystemCommand() {
        super("system");
    }

    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 0) {
            throw new InvalidCommandException("Usage: system <operation> (shutdown, restart, sleep)");
        }

        String operation = args[0].toLowerCase();
        String command = null;

        switch (operation) {
            case "shutdown":
                command = "shutdown /s /t 0";
                break;
            case "restart":
                command = "shutdown /r /t 0";
                break;
            case "sleep":
                command = "rundll32.exe powrprof.dll,SetSuspendState 0,1,0";
                break;
            default:
                throw new InvalidCommandException("Unsupported operation: " + operation + ". Supported: shutdown, restart, sleep");
        }

        // Confirmation for dangerous operations
        if (operation.equals("shutdown") || operation.equals("restart")) {
            System.out.print("Are you sure you want to " + operation + " the system? (yes/no): ");
            Scanner scanner = new Scanner(System.in);
            String confirm = scanner.nextLine().trim().toLowerCase();
            scanner.close();
            if (!confirm.equals("yes")) {
                System.out.println("Operation cancelled.");
                return;
            }
        }

        try {
            new ProcessBuilder(command.split("\\s+")).start();
            System.out.println("System " + operation + " initiated.");
        } catch (IOException e) {
            throw new InvalidCommandException("Failed to " + operation + " system: " + e.getMessage());
        }
    }
}
