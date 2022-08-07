package Common.Commands;
import Common.HumanBeing;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrintFieldDescendingMinutesOfWaitingCommand extends Command{

  @Override
  public void executeCommand() {
    ArrayList<Float> minutes = new ArrayList<>();
    for(HumanBeing instance: list){
      minutes.add(instance.getMinutesOfWaiting());
    }

    Comparator<Float> comparator = Comparator.reverseOrder();
    minutes.sort(comparator);
    minutes.stream().sorted(comparator).forEach(x-> System.out.println(x));
  }
}
