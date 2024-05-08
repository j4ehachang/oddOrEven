package nz.ac.auckland.se281;

public class Easy implements DifficultyLevel{
  
  @Override
  public int selectFingers(){
    ChooseStrategy choosenStrategy = new ChooseStrategy(new Random());
    return choosenStrategy.process();
  }
}
