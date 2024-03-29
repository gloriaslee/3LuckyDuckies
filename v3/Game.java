import java.util.Scanner;

public class Game{

  private static final int RED = 31;
  private static final int GREEN = 32;
  private static final int YELLOW = 33;
  private static final int BLUE = 34;
  private static final int MAGENTA = 35;
  private static final int CYAN = 36;
  private static final int WHITE = 37;
  public static final int RESET = 0;
  //public static final String CLEAR_SCREEN =  "\033[2J";

  private int redTurn = -1; // -1 means green turn, 1 means red turn
  private static Scanner player = new Scanner(System.in);
  //private static Scanner greenPlayer = new Scanner(System.in);
  public Grid gameBoard = new Grid(9,6);

  public boolean turn(){
    // will be used to alternate between player turns
    // take input on dot location
    //System.out.println(CLEAR_SCREEN+RESET);
    int rowInput=0;
    int colInput=0;
    String currentColor;
    int colorInt;

      // check which player needs to go:
      System.out.println(gameBoard);
      if (redTurn==1) {
        colorInt = RED;
        currentColor = DotCluster.colorText(colorInt) + "RED" + DotCluster.colorText(RESET);
      } else {
        colorInt = GREEN;
        currentColor = DotCluster.colorText(colorInt) + "GREEN" + DotCluster.colorText(RESET);
      }

      System.out.println(currentColor + " Player: Please input a location at which you would like to add a dot.");
      // do stuff w/ red player
      System.out.println("First input desired row, then desired column");
      try {
        rowInput = player.nextInt();
        colInput = player.nextInt();

      } catch (Exception e){
        System.out.println("Try again.");
        break;
        return false;

      }
      while (gameBoard.contents[rowInput][colInput].color != colorInt && gameBoard.contents[rowInput][colInput].color != BLUE){
            // accounts for dots inserted in the wrong color and not inserted in blue
          System.out.println("Try again. You put a dot somewhere your opponent has already claimed." + "\n");
            //wait(3000);
          turn();
        redTurn *= -1;
        //System.out.println("You put in the following y coordinate: " + rowInput + " and the following x coordinate: " + colInput);
      }
      gameBoard.addDot(colorInt, rowInput, colInput);
      return true;
  } // end method


  public void runGame() {
    System.out.println("Welcome to ... (drumroll please) CHAIN REACTION!!!");
    while (gameBoard.win == false) {
      turn();
    }
    System.out.println(gameBoard);
  }







}
