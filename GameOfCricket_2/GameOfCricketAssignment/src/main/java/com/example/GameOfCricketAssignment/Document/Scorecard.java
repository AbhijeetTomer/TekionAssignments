package com.example.GameOfCricketAssignment.Document;

import com.example.GameOfCricketAssignment.CricketGame.Player;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.List;

@Document(indexName = "scorecard11")
@Setting(settingPath = "static/es-settings.json")
public class Scorecard {

  @Id
  @Field(type = FieldType.Keyword)
  private String id;

  @Field(type = FieldType.Text)
  private String teamA;

  @Field(type = FieldType.Nested)
  private List<Player> playerListA;

  @Field(type = FieldType.Text)
  private String teamB;

  @Field(type = FieldType.Nested)
  private List<Player> playerListB;

  @Field(type = FieldType.Text)
  private String winner;

  @Field(type = FieldType.Integer)
  private int highscoreA;

  @Field(type = FieldType.Integer)
  private int highscoreB;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTeamA() {
    return teamA;
  }

  public void setTeamA(String teamA) {
    this.teamA = teamA;
  }

  public List<Player> getPlayerListA() {
    return playerListA;
  }

  public void setPlayerListA(List<Player> playerListA) {
    this.playerListA = playerListA;
  }

  public String getTeamB() {
    return teamB;
  }

  public void setTeamB(String teamB) {
    this.teamB = teamB;
  }

  public List<Player> getPlayerListB() {
    return playerListB;
  }

  public void setPlayerListB(List<Player> playerListB) {
    this.playerListB = playerListB;
  }

  public String getWinner() {
    return winner;
  }

  public void setWinner(String winner) {
    this.winner = winner;
  }

  public int getHighscoreA() {
    return highscoreA;
  }

  public void setHighscoreA(int highscoreA) {
    this.highscoreA = highscoreA;
  }

  public int getHighscoreB() {
    return highscoreB;
  }

  public void setHighscoreB(int highscoreB) {
    this.highscoreB = highscoreB;
  }
}
