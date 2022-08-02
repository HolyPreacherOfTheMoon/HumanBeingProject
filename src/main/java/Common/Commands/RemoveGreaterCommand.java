package Common.Commands;

import Common.HumanBeing;
import java.util.Comparator;

public class RemoveGreaterCommand extends Command{
  private HumanBeing insert;

  public RemoveGreaterCommand(HumanBeing insert) {
    this.insert = insert;
  }

  @Override
  public void executeCommand() {
    Comparator<HumanBeing> comparator = HumanBeing::compareTo;
    list.removeIf(instance -> comparator.compare(insert, instance) > 0);
  }
}
