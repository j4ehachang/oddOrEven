package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/** Interface that extends out to the strategies used by the AI to select fingers */
public interface Strategy {
  /**
   * The strategy being used to select the number of fingers for the AI
   *
   * @param roundList The list that contains all of the previous user inputs
   * @param choice The choice the user made for even or odd
   * @return The method for selecting the number of fingers for the AI depending on strategy
   */
  public int fingerStrategy(List<Integer> roundList, Choice choice);
}
