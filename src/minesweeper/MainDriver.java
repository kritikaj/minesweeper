package minesweeper;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.Reader;

public class MainDriver {

  public static final String FILENAME = "/Users/jkritika/pip/minesweeper/resources/InitialSetup.json";

  public static void main(String args[]) {

    Gson gson = new Gson();

    try (Reader reader = new FileReader(FILENAME)) {

      Cell[] cells = gson.fromJson(reader, Cell[].class);
      Game game = new Game(cells);

      game.openGame();
      do{
        game.playGame();
      }while (!game.isGameOver());

      game.showResults();

    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }
}
