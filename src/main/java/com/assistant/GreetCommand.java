package com.assistant;

/**
 * Command to greet the user.
 * Demonstrates basic command implementation.
 */
public class GreetCommand extends Command {

    public GreetCommand() {
        super("hello");
    }

    @Override
    public void execute(String[] args) throws Exception {
        System.out.println("Hello! How can I assist you today?");
    }
}
