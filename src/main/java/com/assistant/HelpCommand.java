package com.assistant;

/**
 * Command to display help information for all available commands.
 * Demonstrates collections and control structures.
 */
public class HelpCommand extends Command {

    public HelpCommand() {
        super("help");
    }

    @Override
    public void execute(String[] args) throws Exception {
        System.out.println("Available commands:");
        System.out.println("  hello - Greet the assistant");
        System.out.println("  time, clock - Display current time");
        System.out.println("  date, today - Display current date");
        System.out.println("  calculate, calc <num1> <op> <num2> - Perform arithmetic (+, -, *, /)");
        System.out.println("  reminder <seconds> <message> - Set a reminder");
        System.out.println("  open <app> - Open application (notepad, chrome, calculator, explorer)");
        System.out.println("  file <operation> <filename> - File operations (create, delete, list)");
        System.out.println("  system <operation> - System operations (shutdown, restart, sleep)");
        System.out.println("  help - Show this help");
        System.out.println("  history - Show command history");
        System.out.println("  exit - Quit the assistant");
    }
}
