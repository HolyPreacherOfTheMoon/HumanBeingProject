package Common.Commands;

import Common.HumanBeing;
import java.util.Comparator;

public class AddIfMinCommand extends Command{
  private HumanBeing insert;

  public AddIfMinCommand(HumanBeing insert) {
    this.insert = insert;
  }

  @Override
  public void executeCommand() {
    Comparator<HumanBeing> comparator = HumanBeing::compareTo;
    HumanBeing min = list.get(0);
    for(HumanBeing instance: list){
      if(comparator.compare(instance, min)<0){
        min=instance;
      }
    }
    if(comparator.compare(min, insert)<0){
      list.add(insert);
    }
  }
}
