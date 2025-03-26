package org.example;

import org.example.managers.*;
import org.example.command.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Основной класс приложения для управления коллекцией музыкальных групп.
 * <p>
 * Приложение предоставляет консольный интерфейс для выполнения команд
 * по управлению коллекцией объектов {@code MusicBand}, которые могут быть
 * сохранены в файл и загружены из него.
 * </p>
 * 
 * <p>Для работы приложения требуется установить переменную окружения
 * {@code MUSIC_BAND_FILE}, содержащую путь к файлу с данными.</p>
 */
public class App {
    /**
     * Точка входа в приложение.
     * <p>
     * Инициализирует менеджеры коллекции, ввода/вывода и файлов,
     * загружает начальную коллекцию из файла и запускает цикл обработки команд.
     * </p>
     * 
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        String filename = System.getenv("MUSIC_BAND_FILE");
        if (filename == null) {
            System.out.println("Переменная окружения MUSIC_BAND_FILE не установлена.");
            return;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileManager fileManager = new FileManager(filename, gson); // Используем значение переменной окружения
        CollectionManager collectionManager = new CollectionManager();
        InputManager inputManager = new InputManager(reader);
        OutputManager outputManager = new OutputManager();

        collectionManager.getCollection().putAll(fileManager.loadCollection());

        List<String> commandHistory = new ArrayList<>();

        Map<String, Command> commands = new HashMap<>();
        commands.put("help", new HelpCommand());
        commands.put("info", new InfoCommand());
        commands.put("show", new ShowCommand());
        commands.put("insert", new InsertCommand());
        commands.put("update", new UpdateCommand());
        commands.put("remove_key", new RemoveKeyCommand());
        commands.put("clear", new ClearCommand());
        commands.put("save", new SaveCommand(fileManager)); // Передаем FileManager
        commands.put("execute_script", new ExecuteScriptCommand(commands)); // Передаем Map команд
        commands.put("exit", new ExitCommand());
        commands.put("history", new HistoryCommand(commandHistory)); // Передаем список истории команд
        commands.put("replace_if_greater", new ReplaceIfGreaterCommand());
        commands.put("remove_lower_key", new RemoveLowerKeyCommand());
        commands.put("sum_of_number_of_participants", new SumOfNumberOfParticipantsCommand());
        commands.put("print_descending", new PrintDescendingCommand());
        commands.put("print_unique_front_man", new PrintUniqueFrontManCommand());

        CommandExecutor commandExecutor = new CommandExecutor(commands, outputManager);

        while (true) {
            try {
                outputManager.printMessage("Введите команду: ");
                String commandLine = inputManager.readLine();

                if (commandHistory.size() >= 7) {
                    commandHistory.remove(0);
                }
                commandHistory.add(commandLine.split(" ")[0]);

                commandExecutor.executeCommand(commandLine, collectionManager);
            } catch (IOException e) {
                outputManager.printError("Ошибка ввода: " + e.getMessage());
            }
        }
    }
}