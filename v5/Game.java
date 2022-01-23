import java.util.*;

public class Game{

  private static final int RED = 31;
  private static final int GREEN = 32;
  private static final int YELLOW = 33;
  private static final int BLUE = 34;
  private static final int MAGENTA = 35;
  private static final int CYAN = 36;
  private static final int WHITE = 37;
  public static final int RESET = 0;
  public static final String CLEAR_SCREEN =  "\033[2J";

  private int turnCounter = 1;
  private int redTurn = -1; // -1 means green turn, 1 means red turn
  int rowInput=0;
  int colInput=0;
  String currentColor;
  int colorInt;

  //private static Scanner greenPlayer = new Scanner(System.in);
  public Grid gameBoard = new Grid(9,6);


  public boolean turn() {
    Text.clear();
    //System.out.println(CLEAR_SCREEN);
    if(turnCounter == 1){
        System.out.println("Welcome to ... (drumroll please) CHAIN REACTION!!!");
    }
    System.out.println("This is Turn #" + turnCounter + "!");
    Scanner player = new Scanner(System.in);
      // check which player needs to go:
      System.out.println(gameBoard);
      if (redTurn == 1) {
        colorInt = RED;
        currentColor = DotCluster.colorText(colorInt) + "RED" + DotCluster.colorText(RESET);
      } else {
        colorInt = GREEN;
        currentColor = DotCluster.colorText(colorInt) + "GREEN" + DotCluster.colorText(RESET);
      }

      System.out.println(currentColor + " Player: Please input a location at which you would like to add a dot.");
      System.out.println("First input desired row, then desired column");


      while(true){
        try{
//for when the user inputs non integer input
          rowInput = player.nextInt();
          colInput = player.nextInt();
          boolean shouldBreak = true;
//for when index input will be out of bounds
          if(rowInput <0 || rowInput>=gameBoard.rows||colInput <0 || colInput>=gameBoard.columns)
      {
          System.out.println("Try again. Index input out of bounds of grid size\n");
          shouldBreak = false;
      }
// accounts for dots inserted in the wrong color and not inserted in blue
      if(gameBoard.contents[rowInput][colInput].color != colorInt && gameBoard.contents[rowInput][colInput].color != BLUE){
            System.out.println("Try again. You put a dot somewhere your opponent has already claimed." + "\n");
            shouldBreak = false;
      }
      if(shouldBreak) {
        break;
      }
    } catch(Exception e){
          System.out.println("Invalid input. Try again");
          player.nextLine();
        }
    }
      gameBoard.addDot(colorInt, rowInput, colInput);
      System.out.println("You put in the following y coordinate: " + rowInput + " and the following x coordinate: " + colInput);
      System.out.println("Dot added!");
      redTurn *= -1;
      turnCounter += 1;
      return true;
  } // end method


  public void runGame() {
    while (gameBoard.win == false) {
      turn();
    }
    System.out.println(gameBoard);
  }







}
