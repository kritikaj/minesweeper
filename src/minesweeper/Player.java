package minesweeper;

public class Player {

  private GameBoard gameBoard;

  public Player(GameBoard gameBoard) {
    this.gameBoard = gameBoard;
  }

  public void playNextMove(Position position, Operation operation) {
    if(operation == Operation.OPEN){
      gameBoard.openCellWithPosition(position);
    }else {
      gameBoard.flagCellWithPosition(position);
    }
  }
}
