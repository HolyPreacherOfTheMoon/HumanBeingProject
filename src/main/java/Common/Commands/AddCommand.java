package Common.Commands;

import Common.HumanBeing;
import java.util.LinkedList;

public class AddCommand extends Command {

  private HumanBeing insert;

  @Override
  public void executeCommand() {
    list.add(insert);
  }
}
