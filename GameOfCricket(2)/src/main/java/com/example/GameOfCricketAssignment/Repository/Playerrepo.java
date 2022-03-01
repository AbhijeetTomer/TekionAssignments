package com.example.GameOfCricketAssignment.Repository;

import com.example.GameOfCricketAssignment.Document.Scorecard;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface Playerrepo extends ElasticsearchRepository<Scorecard, String> {

  List<Scorecard> findByWinner(String winner);
}
