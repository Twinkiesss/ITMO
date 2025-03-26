package org.example.command;

import org.example.managers.CollectionManager;
import org.example.managers.OutputManager;
/**
 * Команда для вывода типа коллекции и количества элементов.
 */
public class InfoCommand implements Command {
    @Override
    public void execute(CollectionManager collectionManager, String[] args, OutputManager outputManager) {
        outputManager.printMessage("Тип коллекции: " + collectionManager.getCollection().getClass().getSimpleName());
        outputManager.printMessage("Количество элементов: " + collectionManager.getCollection().size());
    }
}