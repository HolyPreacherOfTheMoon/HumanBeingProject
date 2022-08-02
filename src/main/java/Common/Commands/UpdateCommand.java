package Common.Commands;

import Common.HumanBeing;

public class UpdateCommand extends Command {

  private HumanBeing insert;

  UpdateCommand(HumanBeing insert) {
    this.insert = insert;
  }

  @Override
  public void executeCommand() {
    HumanBeing updating = findByID(insert.getId());
    if (updating != null) {
      list.remove(updating);
      list.add(insert);
    }
  }

  private HumanBeing findByID(Integer id) {
    for (HumanBeing instance : list) {
      if (instance.getId() == id) {
        return instance;
      }
    }
    return null;
  }
}
