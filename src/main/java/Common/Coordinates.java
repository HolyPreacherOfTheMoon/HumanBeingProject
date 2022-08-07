package Common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coordinates {

  private final double x;
  private final Integer y; // max: 220, Can not be null

  private Coordinates(double x, Integer y) {
    this.x = x;
    this.y = y;
  }

  public static Coordinates createCoordinates() throws IOException {
    String x, y;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      System.out.println("Пожалуйста, координату x.");
      x = br.readLine();
      System.out.println("Пожалуйста, координату y (max 220).");
      y = br.readLine();
      if (isDigit(x, false) && isDigit(y, true)) {
        if (Integer.parseInt(y) <= 220) {
          break;
        } else {
          System.out.println("Вы ввели некорректное значение, пожалуйста, повторите ввод.");
        }
      } else {
        System.out.println("Вы ввели некорректное значение, пожалуйста, повторите ввод.");
      }
    }
    return new Coordinates(Double.parseDouble(x), Integer.parseInt(y));
  }

  private static boolean isDigit(String string, boolean isWhole) {
    if (isWhole) {
      try {
        Integer.parseInt(string);
        return true;
      } catch (NumberFormatException e) {
        return false;
      }
    } else {
      try {
        Float.parseFloat(string);
        return true;
      } catch (NumberFormatException e) {
        return false;
      }
    }
  }

  public double getX() {
    return x;
  }

  public Integer getY() {
    return y;
  }
}
