package Common;

import static Client.Main.isRealAddress;

import Common.HumanBeing;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;


public class JsonJavaInstrument {

  public static void convertJavaToJsonFile(List<HumanBeing> list, String filename) {
    try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filename))) {
      GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
      Gson gson = builder.create();
      gson.toJson(list, bw);
    } catch (IOException e) {
      System.out.println("Что-то пошло не так (скорее всего, не найден файл)");
    }
  }

  public static LinkedList<HumanBeing> convertJsonFileToJava(String filename) throws IOException {
    LinkedList<HumanBeing> list = new LinkedList<>();
    Path path = Paths.get(filename);
    isRealAddress(path);
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    Type type = new TypeToken<LinkedList<HumanBeing>>() {
    }.getType();
    BufferedReader br = new BufferedReader(new FileReader(path.toString()));
    list = gson.fromJson(br, type);
    return list;
  }
}
