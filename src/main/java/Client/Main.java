package Client;

import Common.HumanBeing;
import Common.JsonJavaInstrument;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
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
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String filename = br.readLine();
      LinkedList<HumanBeing> list= JsonJavaInstrument.convertJsonFileToJava(filename);
      JsonJavaInstrument.convertJavaToJsonFile(list,filename);
    }
    catch (IOException e){
      System.out.println("Что-то не так с путем к файлу");
    }
  }
}
