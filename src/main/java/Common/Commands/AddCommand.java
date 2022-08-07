package Common.Commands;

import Common.HumanBeing;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class AddCommand extends Command {

  private HumanBeing insert;

  public AddCommand(HumanBeing insert) {
    this.insert = insert;
  }

  @Override
  public void executeCommand() {
    if(!(insert.getId()==-1)){
      list.add(insert);
    }
  }
}
