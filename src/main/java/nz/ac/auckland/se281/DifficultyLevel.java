package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/** This interface extends to all of the difficulty levels in the game. */
public interface DifficultyLevel {
  /**
   * This method is used to select the number of fingers for the AI depending on the difficulty.
   *
   * @param roundList The list containing all of the preivous inputs by the human.
   * @param choice The choice that the user made for even or odd.
   * @param aiWonLastRound Boolean to see if the AI won the previous round.
   * @return integer representing the number of fingers for the AI.
   */
  public int selectFingers(List<Integer> roundList, Choice choice, Boolean aiWonLastRound);
}
