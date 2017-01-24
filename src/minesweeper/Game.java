package minesweeper;

public class Game {

  private final GameBoard gameBoard;
  private final Player player;
  private boolean isGameOver;
  private final OutputWriter outputWriter;
  private boolean isPlayerTheWinner;


  public Game(Cell[] cells) {
    this.gameBoard = new GameBoard(cells);
    this.player = new Player(gameBoard);
    this.outputWriter = new OutputWriter();
    this.isPlayerTheWinner = false;
    this.isGameOver = false;
  }

  public void playGame() {
    Position position = player.selectCellForNextMove();
    Operation operation = player.selectOperationOnCell();
    player.playNextMove(position,operation);
    gameBoard.showBoard();
    this.isGameOver = getGameStatus();
  }

  public void openGame() {
    gameBoard.showBoard();
  }

  public boolean isGameOver() {
    return isGameOver;
  }

  public void showResults() {
    if(this.isPlayerTheWinner){
      outputWriter.writeOutput("Game Over! You Won !!");
      return;
    }
    outputWriter.writeOutput("GameOver! You Lost !!");
  }

  private boolean getGameStatus() {
    if(!this.isGameOver) {
      if(gameBoard.hasOpenedAllNonMineCells()){
        this.isPlayerTheWinner = true;
        this.isGameOver = true;
        return isGameOver;
      }
      if(gameBoard.hasAMineCellOpened()){
        this.isPlayerTheWinner = false;
        this.isGameOver = true;
        return isGameOver;
      }
    }
    this.isGameOver = false;
    return isGameOver;
  }

}
