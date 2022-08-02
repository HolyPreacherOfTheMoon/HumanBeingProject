package Common.Commands;

import Common.HumanBeing;
import java.util.LinkedList;

public class ShowCommand extends Command{

  @Override
  public void executeCommand() {
    for(HumanBeing instance: list){
      System.out.println(instance);
    }
  }
}
