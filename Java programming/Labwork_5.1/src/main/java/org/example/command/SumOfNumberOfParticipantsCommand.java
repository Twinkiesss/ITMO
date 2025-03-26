package org.example.command;

import org.example.managers.CollectionManager;
import org.example.managers.OutputManager;
import org.example.models.*;

/**
 * Команда для вычисления суммы значений поля numberOfParticipants всех элементов коллекции.
 */
public class SumOfNumberOfParticipantsCommand implements Command {
    @Override
    public void execute(CollectionManager collectionManager, String[] args, OutputManager outputManager) {
        // Вычисление суммы значений поля numberOfParticipants
        long sum = collectionManager.getCollection().values().stream()
                .mapToLong(MusicBand::getNumberOfParticipants)
                .sum();

        // Вывод результата
        outputManager.printMessage("Сумма значений поля numberOfParticipants: " + sum);
    }
}

