package nz.ac.auckland.se281;

import java.util.List;

import nz.ac.auckland.se281.Main.Choice;

public class Medium implements DifficultyLevel{
  
  @Override
  public int selectFingers(List<Integer> roundList, Choice choice){
    if (roundList.size() < 3) {
      ChooseStrategy choosenStrategy = new ChooseStrategy(new Random(), roundList, choice);
      return choosenStrategy.process();

    } else {

      ChooseStrategy choosenStrategy = new ChooseStrategy(new Top(), roundList, choice);
      return choosenStrategy.process();

    }
  }
}
