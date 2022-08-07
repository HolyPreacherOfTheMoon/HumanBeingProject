package Common;

import Common.Exceptions.InvalidPersonCreationArgumentException;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class HumanBeing implements Comparable<HumanBeing> {

  private int id;//must be >0, unique, auto;
  private String name;//Can not be null, string can not be empty
  private Coordinates coordinates;//Can not be null
  private Date creationDate; //Can not be null, auto
  private boolean realHero;
  private boolean hasToothpick; //Can be null
  private Float impactSpeed; //Can be null, must be >-972
  private String soundtrackName; //Can not be null
  private float minutesOfWaiting;
  private WeaponType weaponType; //Can be null
  private Car car; //Can be null

  private HumanBeing(int id, String name, Coordinates coordinates, Date creationDate,
      boolean realHero,
      boolean hasToothpick, Float impactSpeed, String soundtrackName, float minutesOfWaiting,
      WeaponType weaponType, Car car) {
    this.id = id;
    this.name = name;
    this.coordinates = coordinates;
    this.creationDate = creationDate;
    this.realHero = realHero;
    this.hasToothpick = hasToothpick;
    this.impactSpeed = impactSpeed;
    this.soundtrackName = soundtrackName;
    this.minutesOfWaiting = minutesOfWaiting;
    this.weaponType = weaponType;
    this.car = car;
  }

  public static HumanBeing createHumanBeing(List<HumanBeing> list, BufferedReader br)
      throws IOException {
    try {
      Integer id;
      String name, currentInput, soundtrackName;
      boolean isReal, hasToothpick;
      float impactSpeed;
      float minutesOfWaiting;
      Coordinates coordinates;
      WeaponType weaponType1 = null;

      while (true) {
        System.out.println("Пожалуйста, введите имя челоека.");
        name = br.readLine();
        if (name.equals("")) {
          System.out.println("Имя не может быть пустым, пожалуйста, повторите ввод.");
        } else {
          break;
        }
      }

      coordinates = Coordinates.createCoordinates();

      while (true) {
        System.out.println("Пожалуйста, введите, реальный человек или нет. Y/N");
        currentInput = br.readLine();
        if (currentInput.equals("N")) {
          isReal = false;
          break;
        } else {
          if (currentInput.equals("Y")) {
            isReal = true;
            break;
          } else {
            System.out.println("Пожалуйста, повторите ввод.");
          }
        }
      }

      while (true) {
        System.out.println("Пожалуйста, введите, есть ли у человека зубочистка во рту. Y/N");
        currentInput = br.readLine();
        if (currentInput.equals("N")) {
          hasToothpick = false;
          break;
        } else {
          if (currentInput.equals("Y")) {
            hasToothpick = true;
            break;
          } else {
            System.out.println("Пожалуйста, повторите ввод.");
          }
        }
      }

      while (true) {
        System.out.println(
            "Пожалуйста, введите скорость столкновения (атрибут должен быть больше -972)");
        currentInput = br.readLine();
        if (isDigit(currentInput)) {
          if (Float.parseFloat(currentInput) > -972) {
            impactSpeed = Float.parseFloat(currentInput);
            break;
          } else {
            System.out.println("Вы ввели некорректное значение, пожалуйста, повторите ввод.");
          }
        } else {
          System.out.println("Вы ввели некорректное значение, пожалуйста, повторите ввод.");
        }
      }

      System.out.println("Пожалуйста, введите называние саундтрека человека.");
      soundtrackName = br.readLine();

      while (true) {
        System.out.println("Пожалуйста, введите, сколько человек готов ждать.");
        currentInput = br.readLine();
        if (isDigit(currentInput)) {
          minutesOfWaiting = Float.parseFloat(currentInput);
          break;
        } else {
          System.out.println("Вы ввели некорректное значение, пожалуйста, повторите ввод.");
        }
      }
      boolean checker = false;
      while (!checker) {
        System.out.println("Пожалуйста, введите тип оружия у человека. (SHOTGUN/RIFLE/BAT/NULL)");
        currentInput = br.readLine();
        switch (currentInput) {
          case "SHOTGUN" -> {
            weaponType1 = WeaponType.SHOTGUN;
            checker = true;
          }
          case "RIFLE" -> {
            weaponType1 = WeaponType.RIFLE;
            checker = true;
          }
          case "BAT" -> {
            weaponType1 = WeaponType.BAT;
            checker = true;
          }
          case "NULL" -> checker = true;
          default -> System.out.println("Вы ввели некорректное значение, пожалуйста, повторите ввод.");
        }
      }

      System.out.println("Пожалуйста, введите название машины человека.");
      Car car = new Car(br.readLine());
      id = HumanBeing.generateID(list);
      return new HumanBeing(id, name, coordinates, new Date(), isReal, hasToothpick, impactSpeed,
          soundtrackName, minutesOfWaiting, weaponType1, car);
    } catch (Exception e) {
      System.out.println("Что-то пошло не так при создании объекта! Возвращен пустой объект");
      return new HumanBeing(-1, "", null, new Date(), false, false, (float) 0, "", 0, null, null);
    }
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public boolean isRealHero() {
    return realHero;
  }

  public boolean isHasToothpick() {
    return hasToothpick;
  }

  public Float getImpactSpeed() {
    return impactSpeed;
  }

  public String getSoundtrackName() {
    return soundtrackName;
  }

  public float getMinutesOfWaiting() {
    return minutesOfWaiting;
  }

  public WeaponType getWeaponType() {
    return weaponType;
  }

  public Car getCar() {
    return car;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) throws InvalidPersonCreationArgumentException {
    if (name == null || name.equals("")) {
      throw new InvalidPersonCreationArgumentException("The name of the object is null or empty");
    }
    this.name = name;
  }

  public void setCoordinates(Coordinates coordinates)
      throws InvalidPersonCreationArgumentException {
    if (coordinates == null) {
      throw new InvalidPersonCreationArgumentException("The coordinates of the object is null");
    }
    this.coordinates = coordinates;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public void setRealHero(boolean realHero) {
    this.realHero = realHero;
  }

  public void setHasToothpick(boolean hasToothpick) {
    this.hasToothpick = hasToothpick;
  }

  public void setImpactSpeed(Float impactSpeed) throws InvalidPersonCreationArgumentException {
    if (impactSpeed != null && impactSpeed <= -972) {
      throw new InvalidPersonCreationArgumentException(
          "The impact speed of the object is less or equal to -972");
    }
    this.impactSpeed = impactSpeed;
  }

  public void setSoundtrackName(String soundtrackName)
      throws InvalidPersonCreationArgumentException {
    if (soundtrackName == null) {
      throw new InvalidPersonCreationArgumentException("The soundtrack name of the object is null");
    }
    this.soundtrackName = soundtrackName;
  }

  public void setMinutesOfWaiting(float minutesOfWaiting) {
    this.minutesOfWaiting = minutesOfWaiting;
  }

  public void setWeaponType(WeaponType weaponType) {
    this.weaponType = weaponType;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  @Override
  public String toString() {
    return "HumanBeing{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", coordinates=" + coordinates +
        ", creationDate=" + creationDate +
        ", realHero=" + realHero +
        ", hasToothpick=" + hasToothpick +
        ", impactSpeed=" + impactSpeed +
        ", soundtrackName='" + soundtrackName + '\'' +
        ", minutesOfWaiting=" + minutesOfWaiting +
        ", weaponType=" + weaponType +
        ", car=" + car +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof HumanBeing)) {
      return false;
    }
    HumanBeing that = (HumanBeing) o;
    return getId() == that.getId() && isRealHero() == that.isRealHero()
        && isHasToothpick() == that.isHasToothpick()
        && Float.compare(that.getMinutesOfWaiting(), getMinutesOfWaiting()) == 0
        && Objects.equals(getName(), that.getName()) && Objects.equals(
        getCoordinates(), that.getCoordinates()) && Objects.equals(getCreationDate(),
        that.getCreationDate()) && Objects.equals(getImpactSpeed(), that.getImpactSpeed())
        && Objects.equals(getSoundtrackName(), that.getSoundtrackName())
        && getWeaponType() == that.getWeaponType() && Objects.equals(getCar(),
        that.getCar());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getCoordinates(), getCreationDate(), isRealHero(),
        isHasToothpick(), getImpactSpeed(), getSoundtrackName(), getMinutesOfWaiting(),
        getWeaponType(), getCar());
  }

  @Override
  public int compareTo(HumanBeing o) {
    return Integer.compare(this.getId(), o.getId());
  }

  private static boolean isDigit(String string) {
    try {
      Float.parseFloat(string);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private static Integer generateID(List<HumanBeing> list) {
    Random random = new Random();
    int id = 1;
    boolean checker = false;
    while (!checker) {
      checker = true;
      id = random.ints(1, 1, Integer.MAX_VALUE).findFirst().getAsInt();
      for (HumanBeing humanBeing : list) {
        if (humanBeing.getId() == id) {
          checker = false;
          break;
        }
      }
    }
    return id;
  }
}
