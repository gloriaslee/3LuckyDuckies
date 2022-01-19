import java.util.ArrayList;

public class Grid{
  private static final int RED = 31;
  private static final int GREEN = 32;
  private static final int YELLOW = 33;
  private static final int BLUE = 34;
  private static final int MAGENTA = 35;
  private static final int CYAN = 36;
  private static final int WHITE = 37;
  public static final int RESET = 0;


  public int rows = 0;
  public int columns = 0;
  DotCluster[][] contents = new DotCluster[rows][columns]; // is the second half of this statement necessary?

  public Grid(){
    contents = new DotCluster[rows][columns];
  }

  public Grid (int rowsInput, int columnInput){

    //Grid output = new Grid();
    this();
    rows = rowsInput;
    columns = columnInput;
    contents = new DotCluster[rows][columns];

    // contents = new DotCluster[rows][columns];
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < columns; j++){
          contents[i][j] = new DotCluster(0, 34);
          //contents[i][j].maxDot = 4;
          //changing maxDot for special DotClusters:
          if(i==0||i==rows-1){
            if(j==0||j==columns-1){
              contents[i][j].maxDot=2;
            }
          }else if( i==0||i==rows){
            System.out.println(contents[i][j].color);
            contents[i][j].maxDot = 3;
            System.out.println(contents[i][j].maxDot);
          }else if( j==0||j==columns-1 ){

            contents[i][j].maxDot = 3;
            System.out.println(contents[i][j].maxDot);
          }else{
            contents[i][j].maxDot = 4;
          }

      }
    }
    for (int j = 1; j < columns - 1; j++ ){ // not quite the cleanest, but works for now
        contents[0][j].maxDot = 3;
        contents[rows-1][j].maxDot = 3;
    }
  }

  public void addDot(int colorIn, int x, int y){
    // find the location of the dot that needs to be added
    // just add one to that dotCluster
    contents[x][y].numDots = contents[x][y].numDots + 1;
    contents[x][y].color = colorIn;
    if(contents[x][y].numDots==contents[x][y].maxDot){
      explode(colorIn, x,y);
    }
  }

  public void explode(int colorIn, int x, int y){
    contents[x][y].numDots = 0;
    contents[x][y].color = BLUE;

    if(x-1>-1){  //if box directly above exists
      addDot(colorIn, x-1, y);
    }
    if(x+1<rows){ //if box directly below exists
      addDot(colorIn, x+1, y);
    }
    if(y-1>-1){ //if box to the left exists
      addDot(colorIn, x, y-1);
    }
    if(y+1<columns){ //if box to the right exists
      addDot(colorIn, x, y+1);
    }
  }

  public void explodeQueue() {
    // 1. explodes the initial thing
    // 2. makes a list of the explosion that
    // makes a list of explosions that are necessitated by

  }


  // public String toString(){
  //   String output = "";
  //   for (DotCluster[] row: contents){
  //     for (DotCluster i : row){
  //       output += i.toString() + " ";
  //     }
  //     output += "\n";
  //   }
  //   return output;
  // }

  public String toString(){
    String output = "  ";
     // numbers at the top
    for (int rw = 0; rw < columns; rw++){
      output += rw%10 + " ";
    }
    output += "\n";
    for (int j = 0; j < rows; j++){
      output += j%10 + " ";
      for (int i = 0; i < columns; i++){
        output += contents[j][i].toString() + " ";
      }
      output += "\n";
  } return output;
  }

  public String maxDotChecker(){
  String output = "";
    // numbers at the top
   for (int j = 0; j < rows; j++){
     for (int i = 0; i < columns; i++){
       output += contents[j][i].maxDot + " ";
     }
     output += "\n";
    } return output;

  }



}
