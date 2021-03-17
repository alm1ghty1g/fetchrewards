package com.example.fetchrewards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

public class SubtractedPointsHelper {

  @Getter
  Map<String, Integer> subtractedPoints = new HashMap<>();

  public void subtractPoints(String payer, int pointsToSubtract) {

    subtractedPoints.computeIfPresent(payer, (k, v) -> v + (-1 * pointsToSubtract));
    subtractedPoints.putIfAbsent(payer, -1 * pointsToSubtract);
  }

  public List<Payer> getSubtractedPointsForPayers() {

    List<Payer> pointsSpentForPayer = new ArrayList<>();

    for (Map.Entry<String, Integer> entry : subtractedPoints.entrySet()) {
      pointsSpentForPayer.add(new Payer(entry.getKey(), entry.getValue()));
    }

    return pointsSpentForPayer;
  }
}
