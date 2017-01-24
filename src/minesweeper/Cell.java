package minesweeper;

public class Cell {

  private Position position;
  private boolean isMine;
  private boolean isOpen;
  private boolean isFlagged;

  public Cell() {
    this.isOpen = false;
    this.isFlagged = false;
  }


  public boolean hasPosition(Position position) {
    return position.equals(this.position);
  }

  public void openCell() {
    this.isOpen = true;
  }

  public boolean isAMineCell() { return isMine; }

  public void flagCell() {
    this.isFlagged = true;
  }

  public boolean hasBeenFlagged() {
    return isFlagged;
  }

  public boolean hasBeenOpened() {
    return isOpen;
  }

  @Override
  public String toString() {
    return "Cell{" +
        "position=" + position +
        ", isMine=" + isMine +
        '}';
  }
}
