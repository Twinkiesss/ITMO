package org.example.command;

import org.example.managers.CollectionManager;
import org.example.managers.InputManager;
import org.example.managers.OutputManager;
import org.example.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Команда для ввода нового элемента коллекции.
 */
public class InsertCommand implements Command {
    @Override
    public void execute(CollectionManager collectionManager, String[] args, OutputManager outputManager) {
        try {
            if (args.length != 2) {
                outputManager.printError("Неверный ввод команды. Формат: insert {ключ}");
                return;
            }

            int key = Integer.parseInt(args[1]);
            if (key <= 0) {
                outputManager.printError("Ошибка: ключ должен быть больше 0.");
                return;
            }
            if (collectionManager.getCollection().containsKey(key)) {
                outputManager.printError("Ошибка: ключ уже существует.");
                return;
            }

            InputManager inputManager = new InputManager(new BufferedReader(new InputStreamReader(System.in)));

            String name = inputManager.readString("Введите название группы: ");
            long x = inputManager.readLong("Введите координату X: ");
            int y = inputManager.readInt("Введите координату Y: ");
            Coordinates coordinates = new Coordinates(x, y);

            long numberOfParticipants = inputManager.readLong("Введите количество участников: ");
            MusicGenre genre = MusicGenre.valueOf(inputManager.readString("Введите жанр (RAP, HIP_HOP, JAZZ, POP, MATH_ROCK): ").toUpperCase());

            String frontManName = inputManager.readString("Введите имя фронтмена: ");
            int weight = inputManager.readInt("Введите вес фронтмена: ");
            Country nationality = Country.valueOf(inputManager.readString("Введите национальность (RUSSIA, UNITED_KINGDOM, GERMANY, FRANCE, CHINA): ").toUpperCase());

            Person frontMan = new Person(frontManName, weight, nationality);
            MusicBand newBand = new MusicBand(name, coordinates, numberOfParticipants, genre, frontMan);

            collectionManager.addElement(key, newBand);
            outputManager.printMessage("Группа успешно добавлена.");
        } catch (IllegalArgumentException | IOException e) {
            outputManager.printError("Ошибка при вводе данных: " + e.getMessage());
        }
    }
}