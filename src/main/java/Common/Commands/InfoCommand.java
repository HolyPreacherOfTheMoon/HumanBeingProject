package Common.Commands;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InfoCommand extends Command {

  private final Date initializationDate;
  private String result;
  public InfoCommand(Date initializationDate) {
    this.initializationDate = initializationDate;
  }

  @Override
  public void executeCommand() {
    StringBuilder builder = new StringBuilder();
    builder.append("Размер коллекции: ").append(list.size()).append("\n");
    SimpleDateFormat formatForDate = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
    builder.append("Дата инициализации: ").append(formatForDate.format(initializationDate)).append("\n").append("Тип коллекции: LinkedList").append("\n");
    result = builder.toString();
  }

  public void print() {
    System.out.println(result);
  }
}
