package minesweeper;

import java.util.Scanner;

public class InputReader {
  private final Scanner scanner;

  public InputReader() {
    this.scanner =  new Scanner(System.in);
  }

  public int getInput() {
    return scanner.nextInt();
  }
}
