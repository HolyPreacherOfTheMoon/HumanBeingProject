package Common.Commands;

public class HeadCommand extends Command{
  private String toPrint;
  @Override
  public void executeCommand() {
    toPrint = list.get(0).toString();
  }

  @Override
  public void print() {
    System.out.println(toPrint);
  }
}
