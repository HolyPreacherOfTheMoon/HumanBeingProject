package Common;

import Common.Commands.ClearCommand;
import Common.Commands.Command;
import Common.Commands.HeadCommand;
import Common.Commands.HelpCommand;
import Common.Commands.InfoCommand;
import Common.Commands.PrintFieldDescendingMinutesOfWaitingCommand;
import Common.Commands.SaveCommand;
import Common.Commands.ShowCommand;
import Common.Exceptions.RecurrentException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandDeterminator {

  LinkedList<HumanBeing> list;
  Date initializationDate;

  String filename;

  public CommandDeterminator(LinkedList<HumanBeing> list, Date initializationDate,
      String filename) {
    this.list = list;
    this.initializationDate = initializationDate;
    this.filename = filename;
  }

  public void determine(ArrayList<String> usedFilenames, String command) {
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
      }
    } else {
      matcher = stringWithArgument.matcher(command);
      if (matcher.find()) {

      } else {
        //TODO
      }
    }
  }

  private void executeCycle(Command command) {
    try {
      command.setList(list);
      command.executeCommand();
      command.print();
    } catch (RecurrentException e) {
      System.out.println("Выполнение команды execute_script прервано: найдена рекурсия в файле скрипта!");
    }
  }

}
