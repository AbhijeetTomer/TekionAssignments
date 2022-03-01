package com.example.GameOfCricketAssignment.CricketGame;

public class Player {

  public String name;
  public Batting bat;
  public Bowling bowl;

  public Player(String name) {
    this.name = name;
    bat = new Batting();
    bowl = new Bowling();
  }
}
