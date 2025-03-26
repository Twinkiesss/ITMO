package org.example.managers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.models.MusicBand;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс, отвечающий за загрузку и сохранение коллекции в файл.
 */
public class FileManager {
    private final String filename;
    private final Gson gson;

    public FileManager(String filename, Gson gson) {
        this.filename = filename;
        this.gson = gson;
    }

    public Map<Integer, MusicBand> loadCollection() {
        File file = new File(filename);

        if (!file.exists() || file.length() == 0) {
            System.out.println("Файл не найден или пуст. Создана новая коллекция.");
            return new HashMap<>();
        }

        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            Type collectionType = new TypeToken<HashMap<Integer, MusicBand>>() {}.getType();
            return gson.fromJson(fileReader, collectionType);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            return new HashMap<>();
        }
    }

    public void saveCollection(Map<Integer, MusicBand> collection) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(gson.toJson(collection));
        } catch (IOException e) {
            System.out.println("Ошибка сохранения коллекции: " + e.getMessage());
        }
    }
}