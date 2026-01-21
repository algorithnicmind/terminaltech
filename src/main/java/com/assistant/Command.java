package com.assistant;

/**
 * Abstract base class for all commands in the Assistant.
 * Demonstrates abstraction and polymorphism.
 */
public abstract class Command {
    protected String commandName;

    public Command(String commandName) {
        this.commandName = commandName;
    }

    /**
     * Abstract method to execute the command.
     * Subclasses will override this to provide specific behavior.
     */
    public abstract void execute(String[] args) throws Exception;

    public String getCommandName() {
        return commandName;
    }
}
