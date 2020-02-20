package it.lpleo.adventofcode.service;

import it.lpleo.adventofcode.domain.geometry.IPoint;
import it.lpleo.adventofcode.domain.geometry.Straight;
import it.lpleo.adventofcode.domain.geometry.StraightType;
import java.util.List;

public class StraightService {
  
  private static StraightService instance;
  
  public static StraightService getInstance() {
    if(instance == null) {
      instance = new StraightService();
    }
    return instance;
  }
  
  private StraightService() { }
  
  public Straight getStraight(IPoint a, IPoint b) {

    if (a.getX() == b.getX()) {
      return new Straight(StraightType.PARALLELY, 0, 0);
    }

    if (a.getY() == b.getY()) {
      return new Straight(StraightType.PARALLELX, 0, 0);
    }

    double m = (b.getY() - a.getY()) / (b.getX() - a.getX());
    double q = a.getY() - (m * a.getX());
    return new Straight(StraightType.NORMAL, m, q);
  }
  
  public IPoint extractNearestXPositivePoint(List<IPoint> pointList, IPoint source) {
    IPoint result = null;
    for(IPoint candidatePoint : pointList) {
      if(candidatePoint.getX() > 0) {
        
      }
    }
    return result;
  }
}
