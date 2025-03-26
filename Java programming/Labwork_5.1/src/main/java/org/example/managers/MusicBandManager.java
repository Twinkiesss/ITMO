//package org.example.managers;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.reflect.TypeToken;
//import org.example.command.*;
//import org.example.models.*;
//import java.time.LocalDateTime;
//import java.io.*;
//import java.util.*;
//import java.lang.reflect.Type;
//
///**
// * Менеджер для управления коллекцией музыкальных групп.
// * <p>
// * Этот класс отвечает за загрузку, сохранение и управление коллекцией музыкальных групп.
// * Он также предоставляет методы для выполнения команд, таких как добавление, удаление,
// * обновление и вывод информации о коллекции.
// * </p>
// *
// * @author Twinkiesss (Кудряшова Татьяна)
// */
//public class MusicBandManager {
//    private HashMap<Integer, MusicBand> collection;
//    private final LocalDateTime initializationDate;
//    boolean validInput = false;
//    long x, numberOfParticipants;
//    int y;
//    MusicGenre genre = null;
//
//    private final String filename;
//    private BufferedReader reader;
//    private final List<String> commandHistory;
//    private final Map<String, Command> commands;
//    private final Gson gson;
//
//    /**
//     * Конструктор для создания менеджера музыкальных групп.
//     *
//     * @param filename имя файла для загрузки и сохранения коллекции
//     * @throws IOException если возникает ошибка ввода/вывода при загрузке коллекции
//     */
//    public MusicBandManager(String filename) throws IOException {
//        this.filename = filename;
//        this.collection = new HashMap<>();
//        this.reader = new BufferedReader(new InputStreamReader(System.in));
//        this.commandHistory = new ArrayList<>();
//        this.commands = new HashMap<>();
//        this.gson = new GsonBuilder().setPrettyPrinting().create();
//        this.initializationDate = LocalDateTime.now();
//        loadCollection();
//        initializeCommands();
//    }
//
//    /**
//     * Инициализирует команды, доступные для выполнения.
//     */
//    private void initializeCommands() {
//        commands.put("help", new HelpCommand());
//        commands.put("info", new InfoCommand());
//        commands.put("show", new ShowCommand());
//        commands.put("insert", new InsertCommand());
//        commands.put("update", new UpdateCommand());
//        commands.put("remove_key", new RemoveKeyCommand());
//        commands.put("clear", new ClearCommand());
//        commands.put("save", new SaveCommand());
//        commands.put("execute_script", new ExecuteScriptCommand());
//        commands.put("exit", new ExitCommand());
//        commands.put("history", new HistoryCommand());
//        commands.put("replace_if_greater", new ReplaceIfGreaterCommand());
//        commands.put("remove_lower_key", new RemoveLowerKeyCommand());
//        commands.put("sum_of_number_of_participants", new SumOfNumberOfParticipantsCommand());
//        commands.put("print_descending", new PrintDescendingCommand());
//        commands.put("print_unique_front_man", new PrintUniqueFrontManCommand());
//    }
//
//    /**
//     * Загружает коллекцию из файла.
//     */
//    private void loadCollection() {
//        File file = new File(filename);
//
//        if (!file.exists() || file.length() == 0) {
//            System.out.println("Файл не найден или пуст. Создана новая коллекция.");
//            collection = new HashMap<>();
//            return;
//        }
//
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
//            Gson gson = new GsonBuilder()
//                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
//                    .setPrettyPrinting()
//                    .create();
//
//            Type collectionType = new TypeToken<HashMap<Integer, MusicBand>>() {}.getType();
//            HashMap<Integer, MusicBand> loadedCollection = gson.fromJson(fileReader, collectionType);
//
//            if (loadedCollection != null) {
//                collection = loadedCollection;
//                System.out.println("Коллекция успешно загружена. Элементов: " + collection.size());
//            } else {
//                System.out.println("Ошибка: загруженные данные некорректны. Создана новая коллекция.");
//                collection = new HashMap<>();
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("Ошибка: файл не найден. Создана новая коллекция.");
//            collection = new HashMap<>();
//        } catch (IOException e) {
//            System.out.println("Ошибка чтения файла: " + e.getMessage());
//            collection = new HashMap<>();
//        } catch (com.google.gson.JsonSyntaxException e) {
//            System.out.println("Ошибка: некорректный формат JSON. Проверьте содержимое файла.");
//            collection = new HashMap<>();
//        }
//    }
//
//    /**
//     * Выполняет команду, введенную пользователем.
//     *
//     * @param commandLine строка команды, введенная пользователем
//     */
//    public void executeCommand(String commandLine) {
//        String[] parts = commandLine.split(" ");
//        String commandName = parts[0];
//
//        commandHistory.add(commandName);
//        if (commandHistory.size() > 7) {
//            commandHistory.remove(0);
//        }
//
//        Command command = commands.get(commandName);
//        if (command != null) {
//            try {
//                command.execute(this, parts);
//            } catch (NumberFormatException e) {
//                System.out.println("Ошибка: Неверный формат числа в команде.");
//            }
//        } else {
//            System.out.println("Неизвестная команда. Введите help для помощи");
//        }
//    }
//
//    /**
//     * Выводит информацию о коллекции.
//     */
//    public void printInfo() {
//        System.out.println("Тип: HashMap<Integer, MusicBand>");
//        System.out.println("Дата инициализации: " + initializationDate);
//        System.out.println("Размер: " + collection.size());
//    }
//
//    /**
//     * Выводит все элементы коллекции.
//     */
//    public void showCollection() {
//        collection.values().forEach(System.out::println);
//    }
//
//    /**
//     * Выводит историю выполненных команд.
//     */
//    public void printHistory() {
//        commandHistory.forEach(System.out::println);
//    }
//
//    /**
//     * Запускает интерактивный режим работы с коллекцией.
//     */
//    public void start() {
//        System.out.println("Введите команду: ");
//        try {
//            String command;
//            while ((command = reader.readLine()) != null) {
//                executeCommand(command);
//            }
//        } catch (IOException e) {
//            System.out.println("Ошибка ввода: " + e.getMessage());
//        } finally {
//            try {
//                reader.close();
//            } catch (IOException e) {
//                System.out.println("Ошибка закрытия ввода: " + e.getMessage());
//            }
//        }
//    }
//
//    /**
//     * Очищает коллекцию.
//     */
//    public void clearCollection() {
//        collection.clear();
//        saveCollection();
//        System.out.println("Коллекция очищена.");
//    }
//
//    /**
//     * Выполняет скрипт из файла.
//     *
//     * @param args аргументы команды, где args[1] — путь к файлу скрипта
//     */
//    public void executeScript(String[] args) {
//        if (args.length < 2) {
//            System.out.println("Не указан файл скрипта.");
//            return;
//        }
//        try (BufferedReader scriptReader = new BufferedReader(new FileReader(args[1]))) {
//            String line;
//            while ((line = scriptReader.readLine()) != null) {
//                executeCommand(line);
//            }
//        } catch (IOException e) {
//            System.out.println("Ошибка при выполнении скрипта: " + e.getMessage());
//        }
//    }
//
//    /**
//     * Добавляет новый элемент в коллекцию.
//     *
//     * @param args аргументы команды, где args[1] — ключ для добавления элемента
//     */
//    public void insertElement(String[] args) {
//        try {
//            if (args.length != 2) {
//                System.out.println("Неверный ввод команды. Формат: insert {ключ}");
//                return;
//            }
//
//            int key;
//            try {
//                key = Integer.parseInt(args[1]);
//                if (key <= 0) {
//                    System.out.println("Ошибка: ключ должен быть больше 0.");
//                    return;
//                }
//                if (collection.containsKey(key)) {
//                    System.out.println("Ошибка: ключ уже существует.");
//                    return;
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Ошибка: ключ должен быть целым числом.");
//                return;
//            }
//
//            System.out.print("Введите название группы: ");
//            String name = reader.readLine().trim();
//            while (name.isEmpty()) {
//                System.out.println("Название группы не может быть пустым.");
//                name = reader.readLine().trim();
//            }
//
//            while (!validInput) {
//                System.out.print("Введите координату X: ");
//                try {
//                    String input = reader.readLine().trim();
//                    x = Long.parseLong(input);
//                    validInput = true;
//                } catch (NumberFormatException e) {
//                    System.out.println("Ошибка: введите корректное число.");
//                } catch (IOException e) {
//                    System.out.println("Ошибка ввода/вывода: " + e.getMessage() + "Попробуйте снова.");
//                }
//            }
//            validInput = false;
//
//            while (!validInput) {
//                System.out.print("Введите координату Y: ");
//                try {
//                    String input = reader.readLine().trim();
//                    y = Integer.parseInt(input);
//                    validInput = true;
//                } catch (NumberFormatException e) {
//                    System.out.println("Ошибка: введите корректное число.");
//                } catch (IOException e) {
//                    System.out.println("Ошибка ввода/вывода: " + e.getMessage() + "Попробуйте снова.");
//                }
//            }
//            validInput = false;
//            Coordinates coordinates = new Coordinates(x, y);
//
//            while (!validInput) {
//                System.out.print("Введите количество участников: ");
//                try {
//                    String input = reader.readLine().trim();
//                    numberOfParticipants = Long.parseLong(input);
//                    if (numberOfParticipants <= 0) {
//                        System.out.println("Количество участников должно быть больше 0.");
//                    } else {
//                        validInput = true;
//                    }
//                } catch (NumberFormatException e) {
//                    System.out.println("Ошибка: введите корректное число.");
//                } catch (IOException e) {
//                    System.out.println("Ошибка ввода/вывода: " + e.getMessage() + "Попробуйте снова.");
//                }
//            }
//            validInput = false;
//
//            while (genre == null) {
//                try {
//                    System.out.print("Введите жанр (RAP, HIP_HOP, JAZZ, POP, MATH_ROCK): ");
//                    genre = MusicGenre.valueOf(reader.readLine().trim().toUpperCase());
//                } catch (IllegalArgumentException e) {
//                    System.out.println("Ошибка: неверное значение. Попробуйте снова.");
//                }
//            }
//
//            System.out.print("Введите имя фронтмена: ");
//            String frontManName = reader.readLine().trim();
//            while (frontManName.isEmpty()) {
//                System.out.println("Имя фронтмена не может быть пустым.");
//                frontManName = reader.readLine().trim();
//            }
//
//            int weight = 0;
//            while (!validInput) {
//                System.out.print("Введите вес фронтмена: ");
//                try {
//                    String input = reader.readLine().trim();
//                    weight = Integer.parseInt(input);
//                    if (weight <= 0) {
//                        System.out.println("Вес должен быть больше 0.");
//                    } else {
//                        validInput = true;
//                    }
//                } catch (NumberFormatException e) {
//                    System.out.println("Ошибка: введите корректное число.");
//                } catch (IOException e) {
//                    System.out.println("Ошибка ввода/вывода: " + e.getMessage() + "Попробуйте снова.");
//                }
//            }
//            validInput = false;
//
//            Country nationality = null;
//            while (nationality == null) {
//                try {
//                    System.out.print("Введите национальность (RUSSIA, UNITED_KINGDOM, GERMANY, FRANCE, CHINA): ");
//                    nationality = Country.valueOf(reader.readLine().trim().toUpperCase());
//                } catch (IllegalArgumentException e) {
//                    System.out.println("Ошибка: неверное значение. Попробуйте снова.");
//                }
//            }
//
//            Person frontMan = new Person(frontManName, weight, nationality);
//            MusicBand newBand = new MusicBand(name, coordinates, numberOfParticipants, genre, frontMan);
//            collection.put(collection.size() + 1, newBand);
//            System.out.println("Группа успешно добавлена.");
//            saveCollection();
//        } catch (IOException | IllegalArgumentException e) {
//            System.out.println("Ошибка при вводе данных: " + e.getMessage());
//        }
//    }
//
//    /**
//     * Удаляет элемент из коллекции по ключу.
//     *
//     * @param args аргументы команды, где args[1] — ключ элемента для удаления
//     */
//    public void removeElement(String[] args) {
//        if (args.length != 2) {
//            System.out.println("Неверный формат команды. Используйте: remove_key {ключ}");
//            return;
//        }
//
//        String command = args[1];
//        int key;
//        try {
//            key = Integer.parseInt(command);
//        } catch (NumberFormatException e) {
//            System.out.println("Ошибка: неверный формат ключа. Используйте целое число.");
//            return;
//        }
//
//        if (!collection.containsKey(key)) {
//            System.out.println("Ошибка: элемент с ключом " + key + " не найден.");
//            return;
//        }
//
//        collection.remove(key);
//        saveCollection();
//        System.out.println("Элемент с ключом " + key + " успешно удалён.");
//    }
//
//    /**
//     * Обновляет элемент коллекции по его идентификатору.
//     *
//     * @param args аргументы команды, где args[1] — идентификатор элемента, args[2] — поле для обновления
//     */
//    public void updateElement(String[] args) {
//        if (args.length != 3) {
//            System.out.println("Неверный формат команды. Используйте: update {id} {поле}");
//            return;
//        }
//
//        int id;
//        try {
//            id = Integer.parseInt(args[1]);
//        } catch (NumberFormatException e) {
//            System.out.println("Ошибка: ID должен быть целым числом.");
//            return;
//        }
//
//        if (!collection.containsKey(id)) {
//            System.out.println("Ошибка: элемент с таким ID не найден.");
//            return;
//        }
//
//        MusicBand band = collection.get(id);
//        String field = args[2].toLowerCase();
//
//        try {
//            switch (field) {
//                case "name":
//                    System.out.print("Введите новое название группы: ");
//                    String newName = reader.readLine().trim();
//                    if (!newName.isEmpty()) {
//                        band.setName(newName);
//                    } else {
//                        System.out.println("Ошибка: название не может быть пустым.");
//                    }
//                    break;
//
//                case "coordinates":
//                    long x;
//                    int y;
//                    System.out.print("Введите новую координату X: ");
//                    try {
//                        x = Long.parseLong(reader.readLine().trim());
//                    } catch (NumberFormatException e) {
//                        System.out.println("Ошибка: X должен быть числом.");
//                        return;
//                    }
//                    System.out.print("Введите новую координату Y: ");
//                    try {
//                        y = Integer.parseInt(reader.readLine().trim());
//                    } catch (NumberFormatException e) {
//                        System.out.println("Ошибка: Y должен быть числом.");
//                        return;
//                    }
//                    band.setCoordinates(new Coordinates(x, y));
//                    break;
//
//                case "numberofparticipants":
//                    System.out.print("Введите новое количество участников: ");
//                    try {
//                        long participants = Long.parseLong(reader.readLine().trim());
//                        if (participants > 0) {
//                            band.setNumberOfParticipants(participants);
//                        } else {
//                            System.out.println("Ошибка: количество участников должно быть больше 0.");
//                        }
//                    } catch (NumberFormatException e) {
//                        System.out.println("Ошибка: введите корректное число.");
//                    }
//                    break;
//
//                case "genre":
//                    System.out.print("Введите новый жанр (RAP, HIP_HOP, JAZZ, POP, MATH_ROCK): ");
//                    try {
//                        MusicGenre genre = MusicGenre.valueOf(reader.readLine().trim().toUpperCase());
//                        band.setGenre(genre);
//                    } catch (IllegalArgumentException e) {
//                        System.out.println("Ошибка: неверный жанр.");
//                    }
//                    break;
//
//                case "frontman":
//                    System.out.print("Введите новое имя фронтмена: ");
//                    String frontManName = reader.readLine().trim();
//                    System.out.print("Введите новый вес фронтмена: ");
//                    int weight;
//                    try {
//                        weight = Integer.parseInt(reader.readLine().trim());
//                        if (weight <= 0) {
//                            System.out.println("Ошибка: вес должен быть больше 0.");
//                            return;
//                        }
//                    } catch (NumberFormatException e) {
//                        System.out.println("Ошибка: вес должен быть числом.");
//                        return;
//                    }
//                    System.out.print("Введите новую национальность (RUSSIA, UNITED_KINGDOM, GERMANY, FRANCE, CHINA): ");
//                    Country nationality;
//                    try {
//                        nationality = Country.valueOf(reader.readLine().trim().toUpperCase());
//                    } catch (IllegalArgumentException e) {
//                        System.out.println("Ошибка: неверная национальность.");
//                        return;
//                    }
//                    band.setFrontMan(new Person(frontManName, weight, nationality));
//                    break;
//
//                default:
//                    System.out.println("Ошибка: неизвестное поле. Доступные поля: name, coordinates, numberofparticipants, genre, frontman.");
//                    return;
//            }
//
//            System.out.println("Элемент успешно обновлен.");
//            saveCollection();
//
//        } catch (IOException e) {
//            System.out.println("Ошибка ввода/вывода: " + e.getMessage());
//        }
//    }
//
//    /**
//     * Сохраняет коллекцию в файл.
//     */
//    public void saveCollection() {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
//            writer.write(gson.toJson(collection));
//        } catch (IOException e) {
//            System.out.println("Ошибка сохранения коллекции: " + e.getMessage());
//        }
//    }
//
//    /**
//     * Заменяет элемент коллекции, если новое значение больше старого.
//     *
//     * @param args аргументы команды, где args[1] — ключ элемента для замены
//     */
//    public void replaceIfGreater(String[] args) {
//        if (args.length < 2 || !"null".equals(args[1])) {
//            System.out.println("Неверный формат команды. Используйте: replace_if_greater {изменяемый элемент} {ключ}");
//            return;
//        }
//
//        int key;
//        try {
//            key = Integer.parseInt(args[2]); // Ключ для замены
//        } catch (NumberFormatException e) {
//            System.out.println("Ошибка: ключ должен быть целым числом.");
//            return;
//        }
//
//        if (!collection.containsKey(key)) {
//            System.out.println("Ошибка: элемент с ключом " + key + " не найден.");
//            return;
//        }
//
//        if (args.length != 3) {
//            System.out.println("Неверный формат команды. Используйте: update {id} {поле}");
//            return;
//        }
//
//        int id;
//        try {
//            id = Integer.parseInt(args[1]);
//        } catch (NumberFormatException e) {
//            System.out.println("Ошибка: ID должен быть целым числом.");
//            return;
//        }
//
//        if (!collection.containsKey(id)) {
//            System.out.println("Ошибка: элемент с таким ID не найден.");
//            return;
//        }
//
//        MusicBand band = collection.get(id);
//        String field = args[1].toLowerCase();
//
//        try {
//            switch (field) {
//                case "coordinates":
//                    long x;
//                    int y;
//                    System.out.print("Введите новую координату X: ");
//                    try {
//                        x = Long.parseLong(reader.readLine().trim());
//                    } catch (NumberFormatException e) {
//                        System.out.println("Ошибка: X должен быть числом.");
//                        return;
//                    }
//                    System.out.print("Введите новую координату Y: ");
//                    try {
//                        y = Integer.parseInt(reader.readLine().trim());
//                    } catch (NumberFormatException e) {
//                        System.out.println("Ошибка: Y должен быть числом.");
//                        return;
//                    }
//                    if (x > collection.get(id).getCoordinates().getX() && y > collection.get(id).getCoordinates().getY()) {
//                        band.setCoordinates(new Coordinates(x, y));
//                        System.out.println("Данные успешно обновлены.");
//                    } else {
//                        System.out.println("Введенные значения должны быть больше исходных.");
//                    }
//                    break;
//
//                case "numberofparticipants":
//                    System.out.print("Введите новое количество участников: ");
//                    try {
//                        long participants = Long.parseLong(reader.readLine().trim());
//                        if (participants > collection.get(id).getNumberOfParticipants()) {
//                            band.setNumberOfParticipants(participants);
//                        } else {
//                            System.out.println("Ошибка: количество участников должно быть больше исходного.");
//                        }
//                    } catch (NumberFormatException e) {
//                        System.out.println("Ошибка: введите корректное число.");
//                    }
//                    break;
//
//                case "frontman":
//                    System.out.print("Введите новый вес фронтмена: ");
//                    int weight;
//                    try {
//                        weight = Integer.parseInt(reader.readLine().trim());
//                        if (weight <= collection.get(id).getFrontMan().getWeight()) {
//                            System.out.println("Ошибка: вес должен быть больше 0.");
//                            return;
//                        }
//                    } catch (NumberFormatException e) {
//                        System.out.println("Ошибка: вес должен быть числом.");
//                        return;
//                    }
//                    collection.get(id).getFrontMan().setWeight(weight);
//                    break;
//
//                default:
//                    System.out.println("Ошибка: неизвестное поле. Доступные поля: coordinates, numberofparticipants, frontman.");
//                    return;
//            }
//
//            System.out.println("Элемент успешно обновлен.");
//            saveCollection();
//
//        } catch (IOException e) {
//            System.out.println("Ошибка ввода/вывода: " + e.getMessage());
//        }
//    }
//
//    /**
//     * Выводит сумму значений поля {@code numberOfParticipants} всех элементов коллекции.
//     */
//    public void sumOfNumberOfParticipants() {
//        long sum = collection.values().stream()
//                .mapToLong(MusicBand::getNumberOfParticipants)
//                .sum();
//        System.out.println("Сумма значений поля numberOfParticipants: " + sum);
//    }
//
//    /**
//     * Удаляет все элементы коллекции, ключ которых меньше заданного.
//     *
//     * @param key ключ для сравнения
//     */
//    public void removeLowerKey(int key) {
//        int initialSize = collection.size();
//        collection.entrySet().removeIf(entry -> entry.getKey() < key);
//        saveCollection();
//        System.out.println("Удалено " + (initialSize - collection.size()) + " элементов.");
//    }
//
//    /**
//     * Выводит уникальные значения поля {@code frontMan} всех элементов коллекции.
//     */
//    public void printUniqueFrontMen() {
//        Set<String> uniqueFrontMen = new HashSet<>();
//
//        for (MusicBand band : collection.values()) {
//            if (band.getFrontMan() != null) {
//                uniqueFrontMen.add(band.getFrontMan().toString());
//            }
//        }
//
//        if (uniqueFrontMen.isEmpty()) {
//            System.out.println("В коллекции нет уникальных frontMan.");
//        } else {
//            System.out.println("Уникальные frontMan в коллекции:");
//            uniqueFrontMen.forEach(System.out::println);
//        }
//    }
//
//    /**
//     * Выводит элементы коллекции в порядке убывания.
//     */
//    public void printDescending() {
//        List<MusicBand> sortedBands = new ArrayList<>(collection.values());
//        sortedBands.sort(Comparator.comparing(MusicBand::getId).reversed());
//
//        if (sortedBands.isEmpty()) {
//            System.out.println("Коллекция пуста.");
//        } else {
//            System.out.println("Элементы коллекции в порядке убывания:");
//            for (MusicBand band : sortedBands) {
//                System.out.println(band);
//            }
//        }
//    }
//}