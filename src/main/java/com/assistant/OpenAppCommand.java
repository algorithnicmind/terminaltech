package com.assistant;

/**
 * Command to open applications using Runtime.exec().
 * Demonstrates system interaction and exception handling.
 */
public class OpenAppCommand extends Command {

    public OpenAppCommand() {
        super("open");
    }

    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 0) {
            throw new InvalidCommandException("Usage: open <app> (e.g., open notepad, open chrome)");
        }

        String app = args[0].toLowerCase();
        String command = null;

        switch (app) {
            case "notepad":
                command = "notepad.exe";
                break;
            case "chrome":
                command = "cmd /c start chrome";
                break;
            case "calculator":
                command = "calc.exe";
                break;
            case "explorer":
                command = "explorer.exe";
                break;
            default:
                throw new InvalidCommandException("Unsupported app: " + app + ". Supported: notepad, chrome, calculator, explorer");
        }

        try {
            new ProcessBuilder(command.split("\\s+")).start();
            System.out.println("Opened " + app + ".");
        } catch (Exception e) {
            throw new InvalidCommandException("Failed to open " + app + ": " + e.getMessage());
        }
    }
}
