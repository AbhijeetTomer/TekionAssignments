package com.example.GameOfCricketAssignment.CricketGame;

import java.util.ArrayList;
import java.util.List;

public class Team {

  String name;
  int runs;
  int wickets;
  boolean winner;
  int highscore;
  List<Player> players = new ArrayList<>(11); // storing array of objects of 11 Players

  public Team(String name, int runs, int wickets, boolean winner, int highscore, List<Player> players) {
    this.name = name;
    this.runs = runs;
    this.wickets = wickets;
    this.winner = winner;
    this.highscore = highscore;
    this.players = players;
  }
}
