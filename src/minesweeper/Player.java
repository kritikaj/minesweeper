package minesweeper;

public class Player {

  private final OutputWriter outputWriter;
  private final InputReader inputReader;
  private GameBoard gameBoard;

  public Player(GameBoard gameBoard) {
    this.gameBoard = gameBoard;
    this.inputReader = new InputReader();
    this.outputWriter = new OutputWriter();
  }

  public void playNextMove(Position position, Operation operation) {
    if(operation == Operation.OPEN){
      gameBoard.openCellWithPosition(position);
    }else {
      gameBoard.flagCellWithPosition(position);
    }
  }

  public Position selectCellForNextMove() {

    outputWriter.writeOutput("Enter the coordinates of your next move : ");

    int xCoordinates = inputReader.getInput();
    int yCoordinates = inputReader.getInput();

    return new Position(xCoordinates,yCoordinates);

  }

  public Operation selectOperationOnCell() {

    Operation operation;
    int operationChosen;

    outputWriter.writeOutput("1.Flag cell"+"\n"+"2.Open Cell"+"\n"+"Enter choice : ");

    operationChosen = inputReader.getInput();

    operation = determineSelectedOperation(operationChosen);

    return operation;
  }

  private Operation determineSelectedOperation(int operationChosen) {
    if(operationChosen == 1){
      return Operation.FLAG;
    }
    return Operation.OPEN;
  }
}
