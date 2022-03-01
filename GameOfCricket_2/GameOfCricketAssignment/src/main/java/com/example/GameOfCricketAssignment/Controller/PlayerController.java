package com.example.GameOfCricketAssignment.Controller;

import com.example.GameOfCricketAssignment.CricketGame.MatchController;
import com.example.GameOfCricketAssignment.Document.Scorecard;
import com.example.GameOfCricketAssignment.Service.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/player11")
public class PlayerController {

  private PlayerServiceImpl playerService;

  @Autowired
  public PlayerController(PlayerServiceImpl playerService) {
    this.playerService = playerService;
  }

  @Autowired private MatchController matchController;

  @PostMapping("/run") // play match
  public void playmatch() {
    matchController.playmatch();
  }

  @GetMapping("/find/{id}")
  public Scorecard findById(@PathVariable String id) {
    return playerService.findById(id);
  }

  @GetMapping(value = "/find/{winner}") // returning winners name from DB(from all matches)
  public List<Scorecard> findByWinner(@PathVariable String winner) {
    return playerService.findByWinner(winner);
  }

  @GetMapping(value = "/find/all")
  public Iterable<Scorecard> findAll() {
    return playerService.findAll();
  }
}
