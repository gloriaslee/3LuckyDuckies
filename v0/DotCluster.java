public class DotCluster{ // stores information about each DotCluster
  public String color;
  private int numDots, maxDot; // make it final later

  // the following are all the things we will need to refer back to for all instances of DotCluster
  private static final int GREEN = 32;
  private static final int RED = 31;
  public static final int RESET = 0;
  //private static String[] repSet = {"•", "°", "·", "º", "ø", "0", "O", "o"} // the set of characters used to represent 1, 2, 3, and 4 dots in a cluster
  private static String[] repSet = {" ", "·", "o", "O", "ø"} ;// in order: 0 - (just a space), 1 - ·, 2 - o, 3 - O, 4 - ø


  public DotCluster(){
    numDots = 0;

  }

  public static String color(int a){ // creates a tag which you can place in front of the string you want to color
    return ("\033[0"+a+"m" ); // \033[0    \u001B[
  }

  public String toString() {
o
    return "";
  }

  public static void main(String[] args){
    System.out.println(	color(GREEN)+"testing"+color(RESET));
    System.out.println(	color(RED)+"testing"+color(RESET));
  }
}
