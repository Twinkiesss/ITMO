//package org.example.command;
//
//import org.example.managers.MusicBandManager;
//
///**
// * Команда для вывода справки по доступным командам.
// * <p>
// * Реализует интерфейс {@link Command} и выводит список всех доступных команд
// * с их описанием в стандартный поток вывода.
// * </p>
// *
// * @author Twinkiesss (Кудряшова Татьяна)
// */
//public class HelpCommand implements Command {
//
//    /**
//     * Выполняет команду вывода справки по доступным командам.
//     */
//    @Override
//    public void execute(MusicBandManager manager, String[] args) {
//        System.out.println("Доступные команды: \n" +
//                "help : вывести справку по доступным командам\n" +
//                "info : вывести в стандартный поток вывода информацию о коллекции\n" +
//                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
//                "insert null {element} : добавить новый элемент с заданным ключом\n" +
//                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
//                "remove_key null : удалить элемент из коллекции по его ключу\n" +
//                "clear : очистить коллекцию\n" +
//                "save : сохранить коллекцию в файл\n" +
//                "execute_script file_name : считать и исполнить скрипт из указанного файла\n" +
//                "exit : завершить программу (без сохранения в файл)\n" +
//                "history : вывести последние 7 команд (без их аргументов)\n" +
//                "replace_if_greater null {element} : заменить значение по ключу, если новое значение больше старого\n" +
//                "remove_lower_key null : удалить из коллекции все элементы, ключ которых меньше, чем заданный\n" +
//                "sum_of_number_of_participants : вывести сумму значений поля numberOfParticipants для всех элементов коллекции\n" +
//                "print_descending : вывести элементы коллекции в порядке убывания\n" +
//                "print_unique_front_man : вывести уникальные значения поля frontMan всех элементов в коллекции\n");
//    }
//}

package org.example.command;

import org.example.managers.CollectionManager;
import org.example.managers.OutputManager;
/**
 * Команда для вывода команд.
 */
public class HelpCommand implements Command {
    @Override
    public void execute(CollectionManager collectionManager, String[] args, OutputManager outputManager) {
        outputManager.printMessage("Доступные команды: \n" +
                "help : вывести справку по доступным командам\n" +
                "info : вывести информацию о коллекции\n" +
                "show : вывести все элементы коллекции\n" +
                "insert : добавить новый элемент\n" +
                "update : обновить элемент\n" +
                "remove_key : удалить элемент по ключу\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script : выполнить скрипт\n" +
                "exit : завершить программу\n" +
                "history : вывести историю команд\n" +
                "replace_if_greater : заменить элемент, если новый больше\n" +
                "remove_lower_key : удалить элементы с ключом меньше заданного\n" +
                "sum_of_number_of_participants : вывести сумму участников\n" +
                "print_descending : вывести элементы в порядке убывания\n" +
                "print_unique_front_man : вывести уникальных фронтменов\n");
    }
}