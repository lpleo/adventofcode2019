package it.lpleo.adventofcode.domain;

import static java.util.Arrays.asList;

import it.lpleo.adventofcode.y2019.p5.domain.handler.EqualsHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.ErrorHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfFalseHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.JumpIfTrueHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.LessThanHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MoveHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.MultiplicationHandler;
import it.lpleo.adventofcode.y2019.p5.domain.handler.SumHandler;
import it.lpleo.adventofcode.y2019.p7.domain.InputFromVonNeumannMachineHandler;
import it.lpleo.adventofcode.y2019.p7.domain.OutputFromVonNeumannMachineHandler;
import it.lpleo.adventofcode.y2019.p9.domain.handler.ChangeRelativeBaseHandler;
import java.util.List;
import lombok.Getter;

public class HandlerList {

  private static HandlerList istance;

  @Getter
  private List<MoveHandler> handlers;

  public static HandlerList getIstance() {
    if (istance == null) {
      istance = new HandlerList();
    }
    return istance;
  }

  private HandlerList() {
    this.handlers = asList(new SumHandler(),
        new MultiplicationHandler(), new EqualsHandler(), new LessThanHandler(),
        new JumpIfFalseHandler(), new JumpIfTrueHandler(), new InputFromVonNeumannMachineHandler(),
        new OutputFromVonNeumannMachineHandler(), new ChangeRelativeBaseHandler(),
        new ErrorHandler());
  }
}
