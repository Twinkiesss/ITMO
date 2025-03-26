package org.example.managers;

import org.example.command.Command;

import java.util.Map;

public class CommandExecutor {
    private final Map<String, Command> commands;
    private final OutputManager outputManager;

    public CommandExecutor(Map<String, Command> commands, OutputManager outputManager) {
        this.commands = commands;
        this.outputManager = outputManager;
    }

    public void executeCommand(String commandLine, CollectionManager collectionManager) {
        String[] parts = commandLine.split(" ");
        String commandName = parts[0];

        Command command = commands.get(commandName);
        if (command != null) {
            try {
                command.execute(collectionManager, parts, outputManager);
            } catch (NumberFormatException e) {
                outputManager.printError("Неверный формат числа в команде.");
            }
        } else {
            outputManager.printError("Неизвестная команда. Введите help для помощи.");
        }
    }
}