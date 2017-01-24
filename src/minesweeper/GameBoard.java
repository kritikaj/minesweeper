package minesweeper;

public class GameBoard {
  private final Cell[] cells;
  private char[] cellValues;
  private boolean isGameOver;

  public GameBoard(Cell[] cells) {
    this.cells = cells;
    this.cellValues = new char[cells.length];
    this.isGameOver = false;
  }

  public void showBoard() {
    determineCellValues();
    int cellIterator = 0;
    for (int i = 0; i < Math.sqrt(cells.length); i++) {
      for (int j = 0; j < Math.sqrt(cells.length); j++) {
        System.out.print(cellValues[cellIterator++]);
      }
      System.out.println();
    }
  }

  private void determineCellValues() {

    for(int i = 0 ; i< cells.length ; i++){

      if(cells[i].hasBeenOpened()){
        cellValues[i] = '0';
        if(cells[i].isAMineCell()){
          cellValues[i] = 'm';
        }
      }
      else if(cells[i].hasBeenFlagged()){
        cellValues[i] = 'f';
      }
      else{
        cellValues[i] = 'x';
      }
    }
  }

  public void openCellWithPosition(Position position) {
    for (Cell cell : cells) {
      if (cell.hasPosition(position)) {
        cell.openCell();
        if (cell.isAMineCell()) {
          this.isGameOver = true;
        }
        return;
      }
    }
  }

  public void flagCellWithPosition(Position position) {
    for(Cell cell : cells){
      if(cell.hasPosition(position)){
        cell.flagCell();
      }
    }
  }

  public boolean hasNoCellsToSelect() {
    int countOfCellsCovered = 0;
    for (Cell cell:cells) {
      if(cell.hasBeenOpened() || cell.hasBeenFlagged()){
        countOfCellsCovered ++;
      }
    }
    if(countOfCellsCovered == cells.length){
      return true;
    }
    return false;
  }

  public boolean hasAMineCellOpened() {
    for (Cell cell: cells) {
      if(cell.hasBeenOpened() && cell.isAMineCell()){
        return true;
      }
    }
    return false;
  }
}
