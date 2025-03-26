package org.example.command;

import org.example.managers.CollectionManager;
import org.example.managers.OutputManager;
import org.example.models.MusicBand;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Команда для вывода элементов коллекции в порядке убывания.
 */
public class PrintDescendingCommand implements Command {
    @Override
    public void execute(CollectionManager collectionManager, String[] args, OutputManager outputManager) {
        if (collectionManager.getCollection().isEmpty()) {
            outputManager.printMessage("Коллекция пуста.");
        } else {
            outputManager.printMessage("Элементы коллекции в порядке убывания:");

            List<MusicBand> sortedBands = new ArrayList<>(collectionManager.getCollection().values());
            sortedBands.sort(Comparator.comparing(MusicBand::getId).reversed());

            for (MusicBand band : sortedBands) {
                outputManager.printMessage(band.toString());
            }
        }
    }
}
