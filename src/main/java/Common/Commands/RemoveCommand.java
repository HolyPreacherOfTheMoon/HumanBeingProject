package Common.Commands;

import Common.HumanBeing;
import java.util.LinkedList;

public class RemoveCommand extends Command{
  private Integer id;
  RemoveCommand(Integer id) {
    this.id=id;
  }

  @Override
  public void executeCommand() {
    HumanBeing updating = findByID(id);
    if(updating != null){
      list.remove(updating);
    }
  }

  private HumanBeing findByID(Integer id) {
    for (HumanBeing instance : list) {
      if(instance.getId()==id){
        return instance;
      }
    }
    return null;
  }
}
