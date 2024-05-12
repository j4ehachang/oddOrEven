package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public interface DifficultyLevel {
  public int selectFingers(List<Integer> roundList, Choice choice, Boolean aiWonLastRound);
}
