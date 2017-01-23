package minesweeper;

public class Position {
  private int xCoordinate;
  private int yCoordinate;

  public Position(){}

  public Position(int xCoordinate, int yCoordinate) {
    this();
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
  }

  public boolean equals(Position position) {
    if(this.xCoordinate == position.xCoordinate && this.yCoordinate == position.yCoordinate){
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return "Position{" +
        "xCoordinate=" + xCoordinate +
        ", yCoordinate=" + yCoordinate +
        '}';
  }
}
