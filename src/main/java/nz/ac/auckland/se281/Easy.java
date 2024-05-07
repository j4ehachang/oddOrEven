package nz.ac.auckland.se281;

public class Easy implements DifficultyLevel{
  
  @Override
  public int selectFingers(){
    return Utils.getRandomNumberRange(0, 5);
  }
}
