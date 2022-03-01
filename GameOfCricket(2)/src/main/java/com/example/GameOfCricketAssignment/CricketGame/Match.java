package com.example.GameOfCricketAssignment.CricketGame;

public class Match {

  private static int batonstrike = 0;
  private static int batrunner = 1; // initial index of batsman on strike and runner

  public void method_match(Team teambat, Team teambowl, int overs, int inning) {
    int current_over = 0, curr_bowler = 0, curr_bat = 1;

    while (current_over < overs) {
      int no_of_ball = 1;
      // System.out.println(teambat.ob.get(batonstrike).bat.score);
      while (no_of_ball <= 6) {
        if (inning == 2 && checkScore(teambat, teambowl)) {
          System.out.println("Team " + teambat.name + " is winner" + teambat.runs); // checking if team chasing has reached the target
          teambat.winner = true;
          return;
        }
        if (teambat.wickets == 10) { // checking if all batsman are out
          System.out.println("ALL OUT!!");
          return;
        }

        Score_Ball score_ball = new Score_Ball();
        char action = score_ball.return_score(); // retrieving value for run or wicket
        // System.out.println("Action on bowl " + no_of_ball + ": " + action);
        if (action != 'W') { // if run is scored

          int run_scored = Character.getNumericValue(action);
          teambat.players.get(batonstrike).bat.score +=
              run_scored; // updating score of the batsman on strike
          teambowl.players.get(curr_bowler).bowl.runs_conceded +=
              run_scored; // updating runs concede by the bowler
          teambat.runs += run_scored; // adding runs to team score
          // System.out.println("Runs Scored " + run_scored);
          if (run_scored % 2 != 0) {
            swap(); // swapping batsman on strike and runner in case of 1,3,5 runs is scored
          }
          if (run_scored == 4 || run_scored == 6) {
            teambat.players.get(batonstrike).bat.no_of_boundaries +=
                1; // updating no.of boundaries scored by the batsman
          }

        } else { // if the batsman is out

          // System.out.println(teambat.ob[batonstrike].name + " is out!");
          teambowl.players.get(curr_bowler).bowl.no_of_wickets +=
              1; // adding 1 to wickets of the current bowler
          curr_bat++; // index of next batsman
          batonstrike = curr_bat;
          teambat.wickets += 1; // total wickets count
        }
        no_of_ball++;
      }
      swap(); // swapping batsman on strike and runer at the end of the over
      teambowl.players.get(curr_bowler).bowl.overs += 1;
      curr_bowler += 1;

      current_over++;
    }
    if (inning == 2 && checkScore(teambat, teambowl)) {
      // System.out.println("Team " + teambat.name + " is winner");
      teambat.winner = true;
      return;
    }
    if (inning == 2 && !checkScore(teambat, teambowl)) {
      // System.out.println("Team " + teambowl.name + " is winner");
      teambowl.winner = true;
      return;
    }
  }

  private void swap() { // function to interchange batsman on strike and runner
    int temp = batonstrike;
    batonstrike = batrunner;
    batrunner = temp;
  }

  public boolean checkScore(Team teambat, Team teambowl) {
    if (teambat.runs > teambowl.runs) return true;
    return false;
  }
}
