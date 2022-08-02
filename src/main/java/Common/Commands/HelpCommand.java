package Common.Commands;

import Common.HumanBeing;
import java.util.LinkedList;

public class HelpCommand extends Command {


  @Override
  public void executeCommand() {

  }

  public void print (){
    System.out.println("•\thelp : вывести справку по доступным командам\n"
        + "•\tinfo : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n"
        + "•\tshow : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n"
        + "•\tadd {element} : добавить новый элемент в коллекцию\n"
        + "•\tupdate id {element}: обновить значение элемента коллекции, id которого равен заданному\n"
        + "•\tremove_by_id id : удалить элемент из коллекции по его id\n"
        + "•\tclear : очистить коллекцию\n"
        + "•\tsave : сохранить коллекцию в файл\n"
        + "•\texecute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n"
        + "•\texit: завершить программу (без сохранения в файл)\n"
        + "•\thead : вывести первый элемент коллекции\n"
        + "•\tadd_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n"
        + "•\tremove_greater {element}: удалить из коллекции все элементы, превышающие заданный\n"
        + "•\tremove_any_by_weapon_type weaponType : удалить из коллекции один элемент, значение поля weaponType которого эквивалентно заданному\n"
        + "•\tfilter_contains_soundtrack_name soundtrackName : вывести элементы, значение поля soundtrackName которых содержит заданную подстроку\n"
        + "•\tprint_field_descending_minutes_of.waiting : вывести значения поля minutesOfWaiting всех элементов в порядке убывания\n");
  }
}
