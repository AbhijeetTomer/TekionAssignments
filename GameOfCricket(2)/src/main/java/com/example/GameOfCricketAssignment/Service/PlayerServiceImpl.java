package com.example.GameOfCricketAssignment.Service;

import com.example.GameOfCricketAssignment.Document.Scorecard;
import com.example.GameOfCricketAssignment.Repository.Playerrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl {

  @Autowired
  private Playerrepo playerrepo;

  public void save(Scorecard scorecard1) {

    playerrepo.save(scorecard1);
  }

  public List<Scorecard> findByWinner(String winner) {
    List<Scorecard> list = playerrepo.findByWinner(winner);
    return list;
  }

  public Scorecard findById(String id) {

    return playerrepo.findById(id).orElse(null);
  }

  public Iterable<Scorecard> findAll() {

    return playerrepo.findAll();
  }
}
