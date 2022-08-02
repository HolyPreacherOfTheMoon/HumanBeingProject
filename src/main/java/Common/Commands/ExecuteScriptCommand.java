package Common.Commands;

import Common.Exceptions.RecurrentException;
import Common.HumanBeing;
import java.util.ArrayList;

public class ExecuteScriptCommand extends Command {

  private ArrayList<String> usedFilenames;
  private String filename;



  public ExecuteScriptCommand(ArrayList<String> usedFilenames, String filename) {
    this.usedFilenames = usedFilenames;
    this.filename = filename;
  }

  public ExecuteScriptCommand(String filename){
    this.usedFilenames = new ArrayList<>();
    this.filename=filename;
  }

  @Override
  public void executeCommand() throws RecurrentException {
    for (String current: usedFilenames){
      if(current.equals(filename)){
        throw new RecurrentException();
      }
    }
    usedFilenames.add(filename);
    
  }
}
