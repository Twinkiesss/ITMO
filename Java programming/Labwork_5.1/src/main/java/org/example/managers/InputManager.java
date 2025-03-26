package org.example.managers;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Класс, отвечающий за обработку ввода данных от пользователя.
 */
public class InputManager {
    private final BufferedReader reader;

    public InputManager(BufferedReader reader) {
        this.reader = reader;
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }

    public int readInt(String prompt) throws IOException {
        System.out.print(prompt);
        return Integer.parseInt(reader.readLine().trim());
    }

    public long readLong(String prompt) throws IOException {
        System.out.print(prompt);
        return Long.parseLong(reader.readLine().trim());
    }

    public String readString(String prompt) throws IOException {
        System.out.print(prompt);
        return reader.readLine().trim();
    }
}