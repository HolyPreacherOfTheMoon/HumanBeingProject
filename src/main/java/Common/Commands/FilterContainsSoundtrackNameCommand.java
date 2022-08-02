package Common.Commands;

import Common.HumanBeing;

public class FilterContainsSoundtrackNameCommand extends Command {

  private final String soundtrackName;
  private String result;

  FilterContainsSoundtrackNameCommand(String soundtrackName) {
    this.soundtrackName = soundtrackName;
  }

  @Override
  public void executeCommand() {
    StringBuilder sb = new StringBuilder();
    for (HumanBeing instance : list) {
      if (instance.getSoundtrackName().contains(soundtrackName)) {
        sb.append(instance);
      }
    }
    result = sb.toString();
  }

  public void print() {
    System.out.println(result);
  }
}
