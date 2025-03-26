package org.example.command;

import org.example.managers.CollectionManager;
import org.example.managers.OutputManager;

import java.util.List;
/**
 * Команда для вывода истории команд.
 */
public class HistoryCommand implements Command {
    private final List<String> commandHistory;

    public HistoryCommand(List<String> commandHistory) {
        this.commandHistory = commandHistory;
    }

    @Override
    public void execute(CollectionManager collectionManager, String[] args, OutputManager outputManager) {
        if (commandHistory.isEmpty()) {
            outputManager.printMessage("История команд пуста.");
        } else {
            outputManager.printMessage("Последние выполненные команды:");
            commandHistory.forEach(outputManager::printMessage);
        }
    }
}