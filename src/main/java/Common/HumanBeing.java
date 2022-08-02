package Common;

import Common.Exceptions.InvalidPersonCreationArgumentException;
import java.util.Date;
import java.util.Objects;

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

  public HumanBeing() {
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
}
