package Common.Commands;

import Common.HumanBeing;
import java.util.LinkedList;

public class ClearCommand extends Command{


  @Override
  public void executeCommand() {
    list.clear();
  }
}
