package nz.ac.auckland.se281;

import java.util.List;

import nz.ac.auckland.se281.Main.Choice;

public class Random implements Strategy{
  @Override
  public int fingerStrategy(List<Integer> roundList, Choice choice) {
    return Utils.getRandomNumberRange(0, 5);
  }
}
