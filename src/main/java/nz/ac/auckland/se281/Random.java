package nz.ac.auckland.se281;

public class Random implements Strategy{
  @Override
  public int fingerStrategy() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
