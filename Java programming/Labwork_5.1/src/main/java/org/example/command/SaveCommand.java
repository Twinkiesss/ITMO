package org.example.command;

import org.example.managers.CollectionManager;
import org.example.managers.FileManager;
import org.example.managers.OutputManager;

/**
 * Команда для сохранения текущего состояния коллекции в файл.
 * <p>
 * Реализует интерфейс {@link Command} и сохраняет коллекцию музыкальных групп
 * в файл, используя {@link FileManager}. После успешного сохранения
 * выводит подтверждающее сообщение через {@link OutputManager}.
 * </p>
 *
 * <p><b>Пример использования:</b></p>
 * <pre>
 *     new SaveCommand(fileManager).execute(collectionManager, args, outputManager);
 * </pre>
 *
 * @see Command
 * @since 1.0
 */
public class SaveCommand implements Command {
    /**
     * Менеджер для работы с файлом сохранения коллекции.
     */
    private final FileManager fileManager;

    /**
     * Создает новый экземпляр команды save.
     *
     * @param fileManager менеджер для работы с файлом, не может быть null
     * @throws NullPointerException если fileManager равен null
     */
    public SaveCommand(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    /**
     * Выполняет сохранение коллекции в файл.
     * <p>
     * Сохраняет текущее состояние коллекции через {@link FileManager}
     * и выводит сообщение о результате операции.
     * </p>
     *
     * @param collectionManager менеджер коллекции, содержащий данные для сохранения
     * @param args аргументы команды (не используются)
     * @param outputManager менеджер для вывода результатов операции
     */
    @Override
    public void execute(CollectionManager collectionManager, String[] args, OutputManager outputManager) {
        fileManager.saveCollection(collectionManager.getCollection());
        outputManager.printMessage("Коллекция успешно сохранена.");
    }
}