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

  private boolean redTurn = false;
  private static Scanner redPlayer = new Scanner(System.in);
  private static Scanner greenPlayer = new Scanner(System.in);
  public boolean win = false;
  public String whoWon = "no one yet";
  public Grid gameBoard = new Grid(3,3);


public boolean checkWin(){ // resets win to the correct value (whether someone's won or not)


      // goes through the entire board and checks if all contents are one color
      if (gameBoard.contents[i][j].color == RED){
        redDots++;
      } else if (gameBoard.contents[i][j].color == GREEN){
        greenDots++;
      }


  if (redDots == 0 && greenDots > 1){

    whoWon = "GREEN";
    win = true;
      System.out.println(whoWon+" won.");
    return true;
  } else if (greenDots == 0 && redDots > 1){
    win = true;
    whoWon = "RED";
      System.out.println(whoWon+" won.");
    return true;
  }
  return false;
}



//delay printing...
private static void wait(int millis)
{
try {
  Thread.sleep(millis);
}
catch (InterruptedException e) {
}
}

  public void turn(){
    // will be used to alternate between player turns
    // take input on dot location
    //checkWin();
    //System.out.println(CLEAR_SCREEN+RESET);
    int rowInput;
    int colInput;
    int currentColor;
      // check which player needs to go:
      System.out.println(gameBoard);
      if (redTurn) {
        currentColor = RED;
        System.out.println("Red Player: Please input a location at which you would like to add a dot.");
        // do stuff w/ red player
        System.out.println("First input desired row, then desired column");
        rowInput = redPlayer.nextInt();
        colInput = redPlayer.nextInt();
        // while(rowInput<0 || rowInput>gameBoard.rows)
        while (gameBoard.contents[rowInput][colInput].color != currentColor && gameBoard.contents[rowInput][colInput].color != BLUE){
          // accounts for dots inserted in the wrong color and not inserted in blue
          System.out.println("Try again. You put a dot somewhere your opponent has already claimed." + "\n");
          //wait(3000);
          turn();
        }

        redTurn = false;

      } else {
        currentColor = GREEN;
        System.out.println("Green Player: Please input a location at which you would like to add a dot.");
        // do stuff with green player
        System.out.println("First input desired row, then desired column");
        rowInput = greenPlayer.nextInt();
        colInput = greenPlayer.nextInt();
        while (gameBoard.contents[rowInput][colInput].color != currentColor && gameBoard.contents[rowInput][colInput].color != BLUE ){
          System.out.println("Try again. You put a dot somewhere your opponent has already claimed." + "\n");
          //wait(3000);
          turn();
        }
        redTurn = true;
      }
      //wait(2000);
      System.out.println("You put in the following y coordinate: " + rowInput + " and the following x coordinate: " + colInput);
      gameBoard.addDot(currentColor, rowInput, colInput);
      checkWin();
  }

  public void runGame() {

    System.out.println("Welcome to ... (drumroll please) CHAIN REACTION!!!");
    while (win == false) {
      turn();
    }
    System.out.println(gameBoard);
    wait(2000);
  }







}
