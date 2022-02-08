package CricketGame;

public class Player{

  public String name;
  public int age;
  public String details;
  public int score;
  public int no_of_boundaries;
  public int overs;
  public int no_of_wickets;
  public int runs_conceded;

  public Player(
      String name,
      int age,
      String details,
      int score,
      int no_of_boundaries,
      int overs,
      int no_of_wickets,
      int runs_conceded) {
    this.name = name;
    this.age = age;
    this.details = details;
    this.score = score;
    this.no_of_boundaries = no_of_boundaries;
    this.overs = overs;
    this.no_of_wickets = no_of_wickets;
    this.runs_conceded = runs_conceded;
  }
}
