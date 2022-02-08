package CricketGame;

public class Team{

  String name;
  int runs;
  int wickets;
  Player ob[] = new Player[11]; // storing array of objects of 11 Players

  public Team(String name, int runs,int wickets){
    this.name = name;
    this.runs = runs;
    this.wickets=wickets;
  }
}
