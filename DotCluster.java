import java.util.*;

public class DotCluster{ // stores information about each DotCluster

  public int color;
  public int numDots, maxDot; // make it final later

  // the following are all the things we will need to refer back to for all instances of DotCluster

  private static final int RED = 31;
  private static final int GREEN = 32;
  private static final int YELLOW = 33;
  private static final int BLUE = 34;
  private static final int MAGENTA = 35;
  private static final int CYAN = 36;
  private static final int WHITE = 37;
  public static final int RESET = 0;
  //private static String[] repSet = {"•", "°", "·", "º", "ø", "0", "O", "o"} // the set of characters used to represent 1, 2, 3, and 4 dots in a cluster
  private static String[] repSet = {" ", "·", "o", "\u001b[1mO\u001b[7m", "ø"} ;// represents the dotCluster in a way the user can seee
                                                              // in order: 0 dots - (just a space), 1 - ·, 2 - o, 3 - O, 4 - ø
                                                              // the tags on 3 make it bold
  public DotCluster(){
    numDots = 0;
  }

  public DotCluster(int numDotsIn, int colorIn){ // we will use temporarily to check the different outputs of toString
    numDots = numDotsIn;
    color = colorIn;
  }

  public static String colorText(int a){ // creates a tag which you can place in front of the string you want to color
    return ("\033[0"+a+"m" ); // \033[0    \u001B[
  }

  public String toString() {
    String output = "";
    output += colorText(color);
    output += repSet[numDots];
    output += colorText(RESET);
    return output;
  }

  public static void main(String[] args){
    DotCluster bob = new DotCluster(1, GREEN);
    System.out.println(bob); // expecting
  }
}
