public class Woo {

  public static void main(String[] args){
    Game startGame = new Game();
    Grid tiny = new Grid(4,5);
    // System.out.println(tiny.maxDotChecker());
    // System.out.println(tiny);
    // seems to produce errors when I do a 2x3, but not a 3x3
    // System.out.println(tiny.contents[1][2].maxDot);
    startGame.runGame();
    }


  }
