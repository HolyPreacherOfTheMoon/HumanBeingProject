package Common.Commands;

import Common.JsonJavaInstrument;

public class SaveCommand extends Command{
  private String filename;

  public SaveCommand(String filename){
    this.filename=filename;
  }
  @Override
  public void executeCommand() {
    JsonJavaInstrument.convertJavaToJsonFile(list,filename);
  }
}
