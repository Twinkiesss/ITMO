package org.example.command;

import org.example.managers.CollectionManager;
import org.example.managers.InputManager;
import org.example.managers.OutputManager;
import org.example.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Команда для обновления элемента коллекции по его ключу.
 */
public class UpdateCommand implements Command {
    @Override
    public void execute(CollectionManager collectionManager, String[] args, OutputManager outputManager) {
        if (args.length != 2) {
            outputManager.printError("Неверный формат команды. Используйте: update {ключ}");
            return;
        }

        try {
            int key = Integer.parseInt(args[1]);

            if (!collectionManager.getCollection().containsKey(key)) {
                outputManager.printError("Элемент с ключом " + key + " не найден.");
                return;
            }

            MusicBand existingBand = collectionManager.getCollection().get(key);

            InputManager inputManager = new InputManager(new BufferedReader(new InputStreamReader(System.in)));
            MusicBand updatedBand = updateBandFromInput(existingBand, inputManager, outputManager);

            collectionManager.updateElement(key, updatedBand);
            outputManager.printMessage("Элемент с ключом " + key + " успешно обновлён.");
        } catch (NumberFormatException e) {
            outputManager.printError("Ошибка: ключ должен быть целым числом.");
        } catch (IOException e) {
            outputManager.printError("Ошибка ввода: " + e.getMessage());
        }
    }

    /**
     * Обновляет данные элемента на основе ввода пользователя.
     *
     * @param existingBand  текущий элемент коллекции
     * @param inputManager  менеджер ввода
     * @param outputManager менеджер вывода
     * @return обновленный объект MusicBand
     * @throws IOException если возникает ошибка ввода/вывода
     */
    private MusicBand updateBandFromInput(MusicBand existingBand, InputManager inputManager, OutputManager outputManager) throws IOException {
        outputManager.printMessage("Введите новые данные для элемента (оставьте поле пустым, чтобы сохранить текущее значение):");

        // Обновление названия группы
        String name = inputManager.readString("Название группы [" + existingBand.getName() + "]: ");
        if (name.isEmpty()) {
            name = existingBand.getName();
        }

        // Обновление координат
        long x = existingBand.getCoordinates().getX();
        int y = existingBand.getCoordinates().getY();
        String xInput = inputManager.readString("Координата X [" + x + "]: ");
        if (!xInput.isEmpty()) {
            x = Long.parseLong(xInput);
        }
        String yInput = inputManager.readString("Координата Y [" + y + "]: ");
        if (!yInput.isEmpty()) {
            y = Integer.parseInt(yInput);
        }
        Coordinates coordinates = new Coordinates(x, y);

        // Обновление количества участников
        long numberOfParticipants = existingBand.getNumberOfParticipants();
        String participantsInput = inputManager.readString("Количество участников [" + numberOfParticipants + "]: ");
        if (!participantsInput.isEmpty()) {
            numberOfParticipants = Long.parseLong(participantsInput);
            if (numberOfParticipants <= 0) {
                outputManager.printError("Количество участников должно быть больше 0. Используется текущее значение.");
                numberOfParticipants = existingBand.getNumberOfParticipants();
            }
        }

        MusicGenre genre = existingBand.getGenre();
        String genreInput = inputManager.readString("Жанр [" + genre + "]: ");
        if (!genreInput.isEmpty()) {
            try {
                genre = MusicGenre.valueOf(genreInput.toUpperCase());
            } catch (IllegalArgumentException e) {
                outputManager.printError("Неверный жанр. Используется текущее значение.");
            }
        }

        Person frontMan = existingBand.getFrontMan();
        String frontManName = inputManager.readString("Имя фронтмена [" + frontMan.getName() + "]: ");
        if (!frontManName.isEmpty()) {
            frontMan.setName(frontManName);
        }

        int weight = frontMan.getWeight();
        String weightInput = inputManager.readString("Вес фронтмена [" + weight + "]: ");
        if (!weightInput.isEmpty()) {
            weight = Integer.parseInt(weightInput);
            if (weight <= 0) {
                outputManager.printError("Вес должен быть больше 0. Используется текущее значение.");
                weight = frontMan.getWeight();
            }
            frontMan.setWeight(weight);
        }

        Country nationality = frontMan.getNationality();
        String nationalityInput = inputManager.readString("Национальность [" + nationality + "]: ");
        if (!nationalityInput.isEmpty()) {
            try {
                nationality = Country.valueOf(nationalityInput.toUpperCase());
                frontMan.setNationality(nationality);
            } catch (IllegalArgumentException e) {
                outputManager.printError("Неверная национальность. Используется текущее значение.");
            }
        }

        return new MusicBand(name, coordinates, numberOfParticipants, genre, frontMan);
    }
}