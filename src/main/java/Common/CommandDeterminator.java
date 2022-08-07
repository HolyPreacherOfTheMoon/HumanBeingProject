package Common;

import Common.Commands.AddCommand;
import Common.Commands.AddIfMinCommand;
import Common.Commands.ClearCommand;
import Common.Commands.Command;
import Common.Commands.HeadCommand;
import Common.Commands.HelpCommand;
import Common.Commands.InfoCommand;
import Common.Commands.PrintFieldDescendingMinutesOfWaitingCommand;
import Common.Commands.RemoveCommand;
import Common.Commands.SaveCommand;
import Common.Commands.ShowCommand;
import Common.Commands.UpdateCommand;
import Common.Exceptions.RecurrentException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandDeterminator {

  private LinkedList<HumanBeing> list;
  private Date initializationDate;

  private String filename;

  private ArrayList<String> usedFilenames;

  public CommandDeterminator(LinkedList<HumanBeing> list, Date initializationDate, String filename,
      ArrayList<String> usedFilenames) {
    this.list = list;
    this.initializationDate = initializationDate;
    this.filename = filename;
    this.usedFilenames = usedFilenames;
  }

  public CommandDeterminator(LinkedList<HumanBeing> list, Date initializationDate,
      String filename) {
    this.list = list;
    this.initializationDate = initializationDate;
    this.filename = filename;
  }

  public void determine(String command) {
    try {
      Pattern stringWithArgument = Pattern.compile("\\w+\\s+\\w+\\Z");
      Pattern stringWithoutArgument = Pattern.compile("^\\w+\\Z");
      Matcher matcher = stringWithoutArgument.matcher(command);
      if (matcher.find()) {
        switch (command) {
          case "help" -> {
            HelpCommand helpCommand = new HelpCommand();
            executeCycle(helpCommand);
          }
          case "info" -> {
            InfoCommand infoCommand = new InfoCommand(initializationDate);
            executeCycle(infoCommand);
          }
          case "show" -> {
            ShowCommand showCommand = new ShowCommand();
            executeCycle(showCommand);
          }
          case "add" -> {
            AddCommand addCommand = new AddCommand(HumanBeing.createHumanBeing(list,new BufferedReader(new InputStreamReader(System.in))));
            executeCycle(addCommand);
          }
          case "clear" -> {
            ClearCommand clearCommand = new ClearCommand();
            executeCycle(clearCommand);
          }
          case "save" -> {
            SaveCommand saveCommand = new SaveCommand(filename);
            executeCycle(saveCommand);
          }
          case "exit" -> {
            System.exit(0);
          }
          case "head" -> {
            HeadCommand headCommand = new HeadCommand();
            executeCycle(headCommand);
          }
          case "print_field_descending_minutes_of_waiting" -> {
            PrintFieldDescendingMinutesOfWaitingCommand pfdmowCommand = new PrintFieldDescendingMinutesOfWaitingCommand();
            executeCycle(pfdmowCommand);
          }
          case "add_if_min" ->{
            AddIfMinCommand addIfMinCommand = new AddIfMinCommand(HumanBeing.createHumanBeing(list,new BufferedReader(new InputStreamReader(System.in))));
            executeCycle(addIfMinCommand);
          }
        }
      } else {
        matcher = stringWithArgument.matcher(command);
        if (matcher.find()) {
          String[] argumentAndCommand = command.split("\\s");
          command = argumentAndCommand[0];
          String argument = argumentAndCommand[1];
          switch (command) {
            case "update" -> {
              argument = checkArgument(s -> (s.matches("\\d+")), argument);
              UpdateCommand updateCommand = new UpdateCommand(HumanBeing.createHumanBeing(list, new BufferedReader(new InputStreamReader(System.in))), Integer.parseInt(argument));
              executeCycle(updateCommand);
            }
            case "remove_by_id" -> {
              argument = checkArgument(s -> (s.matches("\\d+")), argument);
              RemoveCommand removeCommand = new RemoveCommand(Integer.parseInt(argument));
              executeCycle(removeCommand);
            }

          }
        } else {
          //TODO
        }
      }
    } catch (NumberFormatException e) {
      System.out.println("Проверьте корректность введенных данных!");
    } catch (IOException e) {
      System.out.println("Неустановленный IOException!");
    }
  }


  public void setUsedFilenames(ArrayList<String> usedFilenames) {
    this.usedFilenames = usedFilenames;
  }

  private void executeCycle(Command command) {
    try {
      command.setList(list);
      command.executeCommand();
      command.print();
    } catch (RecurrentException e) {
      System.out.println(
          "Выполнение команды execute_script прервано: найдена рекурсия в файле скрипта!");
    }
  }

  private String checkArgument(Predicate<String> predicate, String argument) throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      while (!predicate.test(argument)) {
        System.out.println("Введено некорректное значение! Введите корректное значение: ");
        argument = br.readLine();
      }
      return argument;
    } catch (IOException e) {
      throw new IOException(e);
    }
  }

}
