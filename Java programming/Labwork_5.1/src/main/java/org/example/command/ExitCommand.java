package org.example.command;

import org.example.managers.CollectionManager;
import org.example.managers.OutputManager;
/**
 * Команда для вывхода.
 */
public class ExitCommand implements Command {
    @Override
    public void execute(CollectionManager collectionManager, String[] args, OutputManager outputManager) {
        outputManager.printMessage("Завершение программы.");
        System.exit(0);
    }
}