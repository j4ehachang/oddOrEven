package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public interface Strategy {
  int fingerStrategy(List<Integer> roundList, Choice choice);
}
