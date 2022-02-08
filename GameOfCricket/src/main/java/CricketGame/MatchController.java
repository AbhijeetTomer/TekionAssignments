package CricketGame;

import java.util.Scanner;

public class MatchController{
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);

    Team teamA = new Team("T1", 0,0);
    Team teamB = new Team("T2", 0,0);
    System.out.println("enter no. of overs");
    int overs = in.nextInt();
    input(teamA);
    input(teamB);
    Match obj = new Match();
    obj.method_match(teamA, teamB, overs, 1);
    print_bat(teamA);
    print_bowl(teamB);
    System.out.println("***************");
    obj.method_match(teamB, teamA, overs, 2);
    print_bat(teamB);
    print_bowl(teamA);

  if(teamB.wickets==10 && teamA.runs>teamB.runs){
    System.out.println("Team " + teamA.name + " is winner");
  }
  }

  private static void input(Team team){

    System.out.println("Enter Teamname");
    Scanner in = new Scanner(System.in);
    String teamname = in.nextLine();
    team.name = teamname;
    team.runs = 0;
    System.out.println("Enter Players");
    for (int i = 0; i < 11; i++) {
      String playername = in.next();
      int age = in.nextInt();
      String details = in.next();
      Player object = new Player(playername, age, details, 0, 0, 0, 0, 0);
      team.ob[i] = object;
    }
  }

  public static void print_bat(Team team){
    System.out.println("Batsman details:");
    for (int i = 0; i < 11; i++) {

      System.out.println("Name" + "\t" + "Score" + "\t" + "No. of boundaries");
      System.out.println(
          team.ob[i].name
              + "\t"
              + "\t"
              + team.ob[i].score
              + "\t"
              + "\t"
              + team.ob[i].no_of_boundaries);
    }
  }

  public static void print_bowl(Team team){
    System.out.println("Bowler Details:");
    for (int i = 0; i < 11; i++) {

      System.out.println("Name" + "\t" + "Wickets" + "\t" + "Runs Conceded");
      System.out.println(
          team.ob[i].name
              + "\t"
              + "\t"
              + team.ob[i].no_of_wickets
              + "\t"
              + "\t"
              + team.ob[i].runs_conceded);
    }
  }
}
