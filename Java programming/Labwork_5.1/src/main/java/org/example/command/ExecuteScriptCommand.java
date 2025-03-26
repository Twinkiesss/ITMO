package org.example.command;

import org.example.managers.CollectionManager;
import org.example.managers.CommandExecutor;
import org.example.managers.OutputManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Команда для выполнения скрипта из файла.
 */
public class ExecuteScriptCommand implements Command {
    private final Map<String, Command> commands;
    private final Set<String> executingScripts;

    public ExecuteScriptCommand(Map<String, Command> commands) {
        this.commands = commands;
        this.executingScripts = new HashSet<>();
    }

    @Override
    public void execute(CollectionManager collectionManager, String[] args, OutputManager outputManager) {
        if (args.length < 2) {
            outputManager.printError("Не указан файл скрипта.");
            return;
        }

        String scriptFileName = args[1];

        // Защита от рекурсии
        if (executingScripts.contains(scriptFileName)) {
            outputManager.printError("Обнаружена рекурсия: файл " + scriptFileName + " уже выполняется.");
            return;
        }
        executingScripts.add(scriptFileName);

        try (BufferedReader scriptReader = new BufferedReader(new FileReader(scriptFileName))) {
            String line;
            CommandExecutor commandExecutor = new CommandExecutor(commands, outputManager);
            StringBuilder multiLineCommand = new StringBuilder();
            int commandCount = 0;

            while ((line = scriptReader.readLine()) != null && commandCount < 1000) {
                line = line.trim();

                if (line.isEmpty() || line.startsWith("//")) {
                    continue;
                }

                if (line.endsWith("\\")) {
                    multiLineCommand.append(line, 0, line.length() - 1).append(" ");
                    continue;
                } else if (multiLineCommand.length() > 0) {
                    multiLineCommand.append(line);
                    line = multiLineCommand.toString();
                    multiLineCommand.setLength(0);
                }

                outputManager.printMessage("[Скрипт] Выполнение команды: " + line);

                try {
                    commandExecutor.executeCommand(line, collectionManager);
                } catch (Exception e) {
                    outputManager.printError("Ошибка при выполнении команды: " + e.getMessage());
                }

                commandCount++;
            }

            if (commandCount >= 1000) {
                outputManager.printError("Превышен лимит на количество команд в скрипте (1000).");
            }
        } catch (IOException e) {
            outputManager.printError("Ошибка при выполнении скрипта: " + e.getMessage());
        } finally {
            executingScripts.remove(scriptFileName);
        }
    }
}

