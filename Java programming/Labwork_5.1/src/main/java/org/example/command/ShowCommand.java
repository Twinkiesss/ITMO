package org.example.command;

import org.example.managers.CollectionManager;
import org.example.managers.OutputManager;

/**
 * Команда для вывода всех элементов коллекции.
 */
public class ShowCommand implements Command {
    @Override
    public void execute(CollectionManager collectionManager, String[] args, OutputManager outputManager) {
        if (collectionManager.getCollection().isEmpty()) {
            outputManager.printMessage("Коллекция пуста.");
        } else {
            outputManager.printMessage("Элементы коллекции:");
            collectionManager.getCollection().values().forEach(band ->
                    outputManager.printMessage(band.toString())
            );
        }
    }
}