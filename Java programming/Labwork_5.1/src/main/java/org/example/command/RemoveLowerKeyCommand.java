package org.example.command;

import org.example.managers.CollectionManager;
import org.example.managers.OutputManager;

/**
 * Команда удаления элементов коллекции с ключами меньше заданного.
 * Удаляет все элементы, чей ключ меньше указанного значения.
 */
public class RemoveLowerKeyCommand implements Command {
    /**
     * Удаляет элементы с ключами меньше указанного.
     *
     * @param collectionManager менеджер коллекции
     * @param args аргументы команды (ожидается 1 аргумент - ключ для сравнения)
     * @param outputManager менеджер вывода результатов
     */
    @Override
    public void execute(CollectionManager collectionManager, String[] args, OutputManager outputManager) {
        if (args.length != 2) {
            outputManager.printError("Неверный формат команды. Используйте: remove_lower_key {ключ}");
            return;
        }

        try {
            int key = Integer.parseInt(args[1]);
            int initialSize = collectionManager.getCollection().size();
            collectionManager.getCollection().entrySet().removeIf(entry -> entry.getKey() < key);
            outputManager.printMessage("Удалено " + (initialSize - collectionManager.getCollection().size()) + " элементов.");
        } catch (NumberFormatException e) {
            outputManager.printError("Ошибка: ключ должен быть целым числом.");
        }
    }
}