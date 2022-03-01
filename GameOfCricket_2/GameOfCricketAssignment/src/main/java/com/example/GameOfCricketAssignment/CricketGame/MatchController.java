package com.example.GameOfCricketAssignment.CricketGame;

import com.example.GameOfCricketAssignment.Document.Scorecard;
import com.example.GameOfCricketAssignment.Service.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class MatchController {

  @Autowired private PlayerServiceImpl playerService;

  public void playmatch() {
    Scanner in = new Scanner(System.in);

    System.out.println("enter no. of overs");
    int overs = in.nextInt();

    Team teamA = null;
    Team teamB = null;
    input(teamA);
    input(teamB);

    Match obj = new Match();
    obj.method_match(teamA, teamB, overs, 1);
    obj.method_match(teamB, teamA, overs, 2);

    findhighscore(teamA);
    findhighscore(teamB);

    String winner = "";
    if (teamA.runs > teamB.runs) {
      teamA.winner = true;
      winner = teamA.name;
      System.out.println("Team " + teamA.name + " " + teamA.winner);
    } else {
      teamB.winner = true;
      winner = teamB.name;
      System.out.println("Team " + teamB.name + " " + teamB.winner);
    }
    Scorecard scorecard = new Scorecard();
    scorecard.setId("5");
    scorecard.setTeamA(teamA.name);
    scorecard.setTeamB(teamB.name);
    scorecard.setHighscoreA(teamA.highscore);
    scorecard.setHighscoreB(teamB.highscore);
    scorecard.setPlayerListA(teamA.players);
    scorecard.setPlayerListB(teamB.players);
    scorecard.setWinner(winner);
    playerService.save(scorecard);
  }

  private static void input(Team team) {

    System.out.println("Enter Team");
    Scanner in = new Scanner(System.in);
    String teamname = in.nextLine();
    List<Player> playerList = new ArrayList<>(11);
    System.out.println("Enter Players");
    for (int i = 0; i < 11; i++) {
      String playername = in.next();
      Player player = new Player(playername);
      playerList.add(player);
    }
    team = new Team(teamname, 0, 0, false, 0, playerList);
  }

  public void findhighscore(Team team) {
    for (int i = 0; i < 11; i++) {

      if (team.highscore < team.players.get(i).bat.score) {
        team.highscore = team.players.get(i).bat.score;
      }
    }
  }
}
