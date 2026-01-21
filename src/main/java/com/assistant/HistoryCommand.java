package com.assistant;

import java.util.List;

/**
 * Command to display command history.
 * Demonstrates collections (ArrayList).
 */
public class HistoryCommand extends Command {

    private List<String> history;

    public HistoryCommand(List<String> history) {
        super("history");
        this.history = history;
    }

    @Override
    public void execute(String[] args) throws Exception {
        if (history.isEmpty()) {
            System.out.println("No commands in history.");
        } else {
            System.out.println("Command history:");
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ". " + history.get(i));
            }
        }
    }
}
