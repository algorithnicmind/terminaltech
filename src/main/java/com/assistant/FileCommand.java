package com.assistant;

import java.io.File;
import java.io.IOException;

/**
 * Command to handle file operations: create, delete, list.
 * Demonstrates file handling and exception management.
 */
public class FileCommand extends Command {

    public FileCommand() {
        super("file");
    }

    @Override
    public void execute(String[] args) throws Exception {
        if (args.length < 2) {
            throw new InvalidCommandException("Usage: file <operation> <filename> [content]");
        }

        String operation = args[0].toLowerCase();
        String filename = args[1];

        switch (operation) {
            case "create":
                createFile(filename);
                break;
            case "delete":
                deleteFile(filename);
                break;
            case "list":
                listFiles(filename.isEmpty() ? "." : filename);
                break;
            default:
                throw new InvalidCommandException("Unsupported operation: " + operation + ". Supported: create, delete, list");
        }
    }

    private void createFile(String filename) throws Exception {
        File file = new File(filename);
        if (file.exists()) {
            throw new InvalidCommandException("File already exists: " + filename);
        }
        try {
            if (file.createNewFile()) {
                System.out.println("Created file: " + filename);
            } else {
                throw new InvalidCommandException("Failed to create file: " + filename);
            }
        } catch (IOException e) {
            throw new InvalidCommandException("Error creating file: " + e.getMessage());
        }
    }

    private void deleteFile(String filename) throws Exception {
        File file = new File(filename);
        if (!file.exists()) {
            throw new InvalidCommandException("File does not exist: " + filename);
        }
        if (file.delete()) {
            System.out.println("Deleted file: " + filename);
        } else {
            throw new InvalidCommandException("Failed to delete file: " + filename);
        }
    }

    private void listFiles(String directory) throws Exception {
        File dir = new File(directory);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new InvalidCommandException("Directory does not exist: " + directory);
        }
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("No files in directory: " + directory);
            return;
        }
        System.out.println("Files in " + directory + ":");
        for (File file : files) {
            System.out.println("  " + (file.isDirectory() ? "[DIR] " : "[FILE] ") + file.getName());
        }
    }
}
