package CricketGame;

public class CricketGame{

  public char array[] = {'0', '1', '2', '3', '4', '5', '6', 'W'};

  public char return_score(){
    int random = (int) (Math.random() * 8);
    return array[random];
  }
}
