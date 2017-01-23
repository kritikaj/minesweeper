package minesweeper;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

public class MainDriver {

  public static final String FILENAME = "/Users/jkritika/pip/minesweeper/resources/InitialSetup.json";

  public static void main(String args[]){

    Gson gson = new Gson();
    int xCoordinates,yCoordinates,operationChosen;

    try (Reader reader = new FileReader(FILENAME)) {

      Cell[] cells = gson.fromJson(reader,Cell[].class);

      GameBoard gameBoard = new GameBoard(cells);
      Scanner scanner = new Scanner(System.in);
      Operation operation;

      gameBoard.showBoard();

      while(!gameBoard.hasGameBeenOver()) {

        System.out.println("Enter coordinates of next move : " );
        xCoordinates = scanner.nextInt();
        yCoordinates = scanner.nextInt();

        System.out.println("1.Flag cell"+"\n"+"2.Open Cell"+"\n"+"Enter choice : ");
        operationChosen = scanner.nextInt();

        if(operationChosen == 1){
          operation = Operation.FLAG;
        }else {
          operation = Operation.OPEN;
        }

        Position position = new Position(xCoordinates,yCoordinates);

        Player player = new Player(gameBoard);
        player.playNextMove(position,operation);

        gameBoard.showBoard();
      }

      System.out.println("Game Over!!");

    } catch (Exception exception) {
      exception.printStackTrace();
    }

  }
}
