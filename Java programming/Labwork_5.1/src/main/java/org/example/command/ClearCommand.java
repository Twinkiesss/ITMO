package org.example.command;

import org.example.managers.CollectionManager;
import org.example.managers.OutputManager;
/**
 * Команда для очищения коллекции
 */
public class ClearCommand implements Command {
    @Override
    public void execute(CollectionManager collectionManager, String[] args, OutputManager outputManager) {
        collectionManager.clearCollection();
        outputManager.printMessage("Коллекция успешно очищена.");
    }
}