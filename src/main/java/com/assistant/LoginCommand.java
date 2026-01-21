package com.assistant;

/**
 * Command to log in a user.
 * Demonstrates state management and user profiles.
 */
public class LoginCommand extends Command {
    private static String currentUser = null;

    public static void logout() {
        currentUser = null;
    }

    public LoginCommand() {
        super("login");
    }

    @Override
    public void execute(String[] args) throws Exception {
        if (args.length != 1) {
            throw new InvalidCommandException("Usage: login <username>");
        }
        currentUser = args[0];
        System.out.println("Logged in as: " + currentUser);
        Logger.log("User logged in: " + currentUser);
    }

    public static String getCurrentUser() {
        return currentUser;
    }
}
