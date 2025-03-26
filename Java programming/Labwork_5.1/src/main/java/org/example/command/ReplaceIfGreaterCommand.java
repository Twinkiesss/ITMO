//package org.example.command;
//
//import org.example.managers.MusicBandManager;
//
///**
// * Команда для замены элемента коллекции, если новое значение больше старого.
// * <p>
// * Реализует интерфейс {@link Command} и заменяет элемент коллекции,
// * если новое значение больше текущего, с помощью метода
// * {@link MusicBandManager#replaceIfGreater(String[])}.
// * </p>
// *
// * @author Twinkiesss (Кудряшова Татьяна)
// */
//public class ReplaceIfGreaterCommand implements Command {
//
//    /**
//     * Выполняет команду замены элемента коллекции, если новое значение больше старого.
//     *
//     * @param manager менеджер музыкальных групп, который управляет коллекцией
//     * @param args    аргументы команды, содержащие данные для сравнения и замены
//     */
//    @Override
//    public void execute(MusicBandManager manager, String[] args) {
//        manager.replaceIfGreater(args);
//    }
//}
package org.example.command;

import org.example.managers.*;
import org.example.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Команда для замены элемента коллекции, если новый элемент больше текущего.
 */
public class ReplaceIfGreaterCommand implements Command {
    @Override
    public void execute(CollectionManager collectionManager, String[] args, OutputManager outputManager) {
        if (args.length != 2) {
            outputManager.printError("Неверный формат команды. Используйте: replace_if_greater {ключ}");
            return;
        }

        try {
            int key = Integer.parseInt(args[1]);

            // Проверка существования элемента с указанным ключом
            if (!collectionManager.getCollection().containsKey(key)) {
                outputManager.printError("Элемент с ключом " + key + " не найден.");
                return;
            }

            // Создание нового элемента для сравнения
            InputManager inputManager = new InputManager(new BufferedReader(new InputStreamReader(System.in)));
            MusicBand newBand = createBandFromInput(inputManager, outputManager);

            // Сравнение и замена, если новый элемент больше
            MusicBand existingBand = collectionManager.getCollection().get(key);
            if (newBand.compareTo(existingBand) > 0) {
                collectionManager.updateElement(key, newBand);
                outputManager.printMessage("Элемент с ключом " + key + " успешно заменён.");
            } else {
                outputManager.printMessage("Новый элемент не больше существующего. Замена не выполнена.");
            }
        } catch (NumberFormatException e) {
            outputManager.printError("Ошибка: ключ должен быть целым числом.");
        } catch (IOException e) {
            outputManager.printError("Ошибка ввода: " + e.getMessage());
        }
    }

    /**
     * Создает новый элемент MusicBand на основе ввода пользователя.
     *
     * @param inputManager  менеджер ввода
     * @param outputManager менеджер вывода
     * @return новый объект MusicBand
     * @throws IOException если возникает ошибка ввода/вывода
     */
    private MusicBand createBandFromInput(InputManager inputManager, OutputManager outputManager) throws IOException {
        outputManager.printMessage("Введите данные для нового элемента:");

        // Ввод названия группы
        String name = inputManager.readString("Название группы: ");
        while (name.isEmpty()) {
            outputManager.printError("Название группы не может быть пустым.");
            name = inputManager.readString("Название группы: ");
        }

        // Ввод координат
        long x = inputManager.readLong("Координата X: ");
        int y = inputManager.readInt("Координата Y: ");
        Coordinates coordinates = new Coordinates(x, y);

        // Ввод количества участников
        long numberOfParticipants = inputManager.readLong("Количество участников: ");
        while (numberOfParticipants <= 0) {
            outputManager.printError("Количество участников должно быть больше 0.");
            numberOfParticipants = inputManager.readLong("Количество участников: ");
        }

        // Ввод жанра
        MusicGenre genre = null;
        while (genre == null) {
            try {
                genre = MusicGenre.valueOf(inputManager.readString("Жанр (RAP, HIP_HOP, JAZZ, POP, MATH_ROCK): ").toUpperCase());
            } catch (IllegalArgumentException e) {
                outputManager.printError("Неверный жанр. Попробуйте снова.");
            }
        }

        // Ввод данных о фронтмене
        String frontManName = inputManager.readString("Имя фронтмена: ");
        while (frontManName.isEmpty()) {
            outputManager.printError("Имя фронтмена не может быть пустым.");
            frontManName = inputManager.readString("Имя фронтмена: ");
        }

        int weight = inputManager.readInt("Вес фронтмена: ");
        while (weight <= 0) {
            outputManager.printError("Вес должен быть больше 0.");
            weight = inputManager.readInt("Вес фронтмена: ");
        }

        Country nationality = null;
        while (nationality == null) {
            try {
                nationality = Country.valueOf(inputManager.readString("Национальность (RUSSIA, UNITED_KINGDOM, GERMANY, FRANCE, CHINA): ").toUpperCase());
            } catch (IllegalArgumentException e) {
                outputManager.printError("Неверная национальность. Попробуйте снова.");
            }
        }

        Person frontMan = new Person(frontManName, weight, nationality);
        return new MusicBand(name, coordinates, numberOfParticipants, genre, frontMan);
    }
}

