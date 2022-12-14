package Client;

import Common.CommandDeterminator;
import Common.Commands.HeadCommand;
import Common.Commands.HelpCommand;
import Common.HumanBeing;
import Common.JsonJavaInstrument;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.Date;
import java.util.LinkedList;


public class Main {

  public static boolean isRealAddress(Path filenamePath) throws IOException {
    if (filenamePath.toRealPath().toString().length() > 3 && filenamePath.toRealPath().toString()
        .trim().startsWith("/dev")) {
      throw new FileNotFoundException();
    } else {
      return true;
    }
  }

  public static void main(String[] args){
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
      String filename = br.readLine();
      LinkedList<HumanBeing> list= JsonJavaInstrument.convertJsonFileToJava(filename);
      CommandDeterminator determinator = new CommandDeterminator(list, new Date(), filename);
      HelpCommand helpCommand = new HelpCommand();
      helpCommand.print();
      while(true){
        String command = br.readLine();
        determinator.determine(command);
      }
    }
    catch (IOException e){
      e.printStackTrace();
      System.out.println("Что-то не так с путем к файлу");
    }
  }
}
