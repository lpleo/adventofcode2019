package it.lpleo.adventofcode.service.vonneumannmachine;

import static java.util.Arrays.asList;

import it.lpleo.adventofcode.service.vonneumannmachine.handlers.InputHandler;
import it.lpleo.adventofcode.service.vonneumannmachine.handlers.OutputHandler;
import it.lpleo.adventofcode.service.vonneumannmachine.handlers.EqualsHandler;
import it.lpleo.adventofcode.service.vonneumannmachine.handlers.ErrorHandler;
import it.lpleo.adventofcode.service.vonneumannmachine.handlers.JumpIfFalseHandler;
import it.lpleo.adventofcode.service.vonneumannmachine.handlers.JumpIfTrueHandler;
import it.lpleo.adventofcode.service.vonneumannmachine.handlers.LessThanHandler;
import it.lpleo.adventofcode.service.vonneumannmachine.handlers.MoveHandler;
import it.lpleo.adventofcode.service.vonneumannmachine.handlers.MultiplicationHandler;
import it.lpleo.adventofcode.service.vonneumannmachine.handlers.SumHandler;
import it.lpleo.adventofcode.service.vonneumannmachine.handlers.ChangeRelativeBaseHandler;
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
        new JumpIfFalseHandler(), new JumpIfTrueHandler(), new InputHandler(),
        new OutputHandler(), new ChangeRelativeBaseHandler(),
        new ErrorHandler());
  }
}
