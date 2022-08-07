package Common.Commands;

import Common.HumanBeing;

public class UpdateCommand extends Command {

  private HumanBeing insert;
  private Integer id;

  public UpdateCommand(HumanBeing insert, Integer id) {
    this.insert = insert;
    this.id=id;
  }

  @Override
  public void executeCommand() {
    HumanBeing updating = findByID(insert.getId());
    if (updating != null) {
      list.remove(updating);
      list.add(insert);
      insert.setId(id);
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
