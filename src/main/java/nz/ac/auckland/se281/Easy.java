package nz.ac.auckland.se281;
import java.util.List;

import nz.ac.auckland.se281.Main.Choice;

public class Easy implements DifficultyLevel{
  
  @Override
  public int selectFingers(List<Integer> roundList, Choice choice){
    ChooseStrategy choosenStrategy = new ChooseStrategy(new Random(), roundList, choice);
    return choosenStrategy.process();
  }
}
