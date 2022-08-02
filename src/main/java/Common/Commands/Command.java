package Common.Commands;

import Common.Exceptions.RecurrentException;
import Common.HumanBeing;
import java.util.LinkedList;

public abstract class Command {

  protected LinkedList<HumanBeing> list;


  public LinkedList<HumanBeing> getList() {
    return list;
  }

  public void setList(LinkedList<HumanBeing> list) {
    this.list = list;
  }

  public abstract void executeCommand() throws RecurrentException;

  public void print(){};

}
