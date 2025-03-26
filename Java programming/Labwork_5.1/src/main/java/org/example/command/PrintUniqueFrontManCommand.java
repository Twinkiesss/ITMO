package org.example.command;

import org.example.managers.CollectionManager;
import org.example.managers.OutputManager;

import java.util.HashSet;
import java.util.Set;

/**
 * Команда для вывода уникальных значений поля frontMan всех элементов коллекции.
 * Формирует множество уникальных строковых представлений фронтменов и выводит их.
 */
public class PrintUniqueFrontManCommand implements Command {
    /**
     * Выполняет поиск и вывод уникальных фронтменов коллекции.
     * <p>
     * Собирает уникальные строковые представления всех фронтменов в коллекции
     * и выводит их. Если фронтмены отсутствуют или коллекция пуста,
     * выводится соответствующее сообщение.
     * </p>
     *
     * @param collectionManager менеджер коллекции, содержащий данные о музыкальных группах
     * @param args аргументы команды (не используются)
     * @param outputManager менеджер для вывода результатов
     */
    @Override
    public void execute(CollectionManager collectionManager, String[] args, OutputManager outputManager) {
        Set<String> uniqueFrontMen = new HashSet<>();
        collectionManager.getCollection().values().forEach(band -> {
            if (band.getFrontMan() != null) {
                uniqueFrontMen.add(band.getFrontMan().toString());
            }
        });

        if (uniqueFrontMen.isEmpty()) {
            outputManager.printMessage("В коллекции нет уникальных frontMan.");
        } else {
            outputManager.printMessage("Уникальные frontMan в коллекции:");
            uniqueFrontMen.forEach(outputManager::printMessage);
        }
    }
}