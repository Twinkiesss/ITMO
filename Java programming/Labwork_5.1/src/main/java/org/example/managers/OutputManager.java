package org.example.managers;

import org.example.models.MusicBand;

import java.util.Collection;

/**
 * Класс, отвечающий за вывод данных пользователю.
 */
public class OutputManager {
    public void printInfo(String info) {
        System.out.println(info);
    }

    public void printCollection(Collection<MusicBand> bands) {
        bands.forEach(System.out::println);
    }

    public void printError(String error) {
        System.out.println("Ошибка: " + error);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}