package org.example.command;

import org.example.managers.CollectionManager;
import org.example.managers.OutputManager;

/**
 * Команда для удаления элемента коллекции по указанному ключу.
 * Удаляет элемент с заданным ключом, если такой существует в коллекции.
 */
public class RemoveKeyCommand implements Command {
    /**
     * Выполняет удаление элемента по ключу.
     *
     * @param collectionManager менеджер коллекции, из которой будет удален элемент
     * @param args массив аргументов команды (требуется 1 аргумент - ключ элемента)
     * @param outputManager менеджер для вывода результатов операции
     */
    @Override
    public void execute(CollectionManager collectionManager, String[] args, OutputManager outputManager) {
        if (args.length != 2) {
            outputManager.printError("Неверный формат команды. Используйте: remove_key {ключ}");
            return;
        }

        try {
            int key = Integer.parseInt(args[1]);
            if (collectionManager.getCollection().containsKey(key)) {
                collectionManager.removeElement(key);
                outputManager.printMessage("Элемент с ключом " + key + " успешно удалён.");
            } else {
                outputManager.printError("Элемент с ключом " + key + " не найден.");
            }
        } catch (NumberFormatException e) {
            outputManager.printError("Ошибка: ключ должен быть целым числом.");
        }
    }
}