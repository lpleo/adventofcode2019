package it.lpleo.adventofcode.y2019.p5.domain.handler;

import it.lpleo.adventofcode.y2019.p2.domain.VonNeumannMachine;
import it.lpleo.adventofcode.y2019.p2.domain.handler.MoveHandler;
import java.io.InputStream;
import java.util.Scanner;

public class InputHandler implements MoveHandler {

  private Scanner scanner;
  
  public InputHandler() {
    this.scanner = new Scanner(System.in);
  }
  
  public InputHandler(InputStream inputStream) {
    this.scanner = new Scanner(inputStream);
  }
  
  @Override
  public boolean shouldHandle(int moveValue) {
    return moveValue == 3;
  }

  @Override
  public void move(VonNeumannMachine vonNeumannMachine) {
    int cursor = vonNeumannMachine.getCursor();
    int position = vonNeumannMachine.getValue(cursor + 1);
    System.out.println("Insert value: ");
    vonNeumannMachine.write(position, scanner.nextInt());
    vonNeumannMachine.move(cursor + 2);
  }
}
