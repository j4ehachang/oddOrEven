package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class Top implements Strategy {
  private int evenCount = 0;
  private int oddCount = 0;

  @Override
  public int fingerStrategy(List<Integer> roundList, Choice choice) {
    for (Integer integer : roundList) {
      if (Utils.isEven(integer)) {
        evenCount++;
      } else {
        oddCount++;
      }
    }

    if ((evenCount > oddCount && choice == Choice.EVEN)
        || (oddCount > evenCount && choice == Choice.ODD)) {
      return Utils.getRandomOddNumber();

    } else if ((oddCount > evenCount && choice == Choice.EVEN)
        || (evenCount > oddCount && choice == Choice.ODD)) {
      return Utils.getRandomEvenNumber();

    } else {
      return Utils.getRandomNumberRange(0, 5);
    }
  }
}
