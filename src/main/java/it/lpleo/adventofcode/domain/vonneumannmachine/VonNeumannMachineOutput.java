package it.lpleo.adventofcode.domain.vonneumannmachine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VonNeumannMachineOutput {
  private boolean wait;
  private double result;
}
