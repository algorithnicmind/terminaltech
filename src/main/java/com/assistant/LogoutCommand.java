package com.assistant;

/**
 * Command to log out the current user.
 * Demonstrates state management.
 */
public class LogoutCommand extends Command {

    public LogoutCommand() {
        super("logout");
    }

    @Override
    public void execute(String[] args) throws Exception {
        if (LoginCommand.getCurrentUser() == null) {
            throw new InvalidCommandException("No user is logged in.");
        }
        String user = LoginCommand.getCurrentUser();
        LoginCommand.logout(); // Reset to null
        System.out.println("Logged out: " + user);
        Logger.log("User logged out: " + user);
    }
}
