import java.util.*;

import java.util.ArrayList;

public class Grid{

  ArrayList<int[]> queue = new ArrayList<int[]>();


  public int rows = 0;
  public int columns = 0;
  public String whoWon = "no one yet"; // both of these need to be accessable from Grid
  public boolean win = false;
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
          }else if( i==0||i==rows-1){

            contents[i][j].maxDot = 3;

          }else if( j==0||j==columns-1 ){

            contents[i][j].maxDot = 3;

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

  public void checkWin(){ // resets win to the correct value (whether someone's won or not)
    int redDots = 0;
    int greenDots = 0;
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < columns; j++){
        // goes through the entire board and checks if all contents are one color
        if (contents[i][j].color == Text.RED){
          redDots++;
        } else if (contents[i][j].color == Text.GREEN){
          greenDots++;
        }
      }
    }
    if (redDots == 0 && greenDots > 1){
      win = true;
      whoWon = "GREEN";
    } else if (greenDots == 0 && redDots > 1){
      win = true;
      whoWon = "RED";
    }
    System.out.println(whoWon+" won.");
  }


  public void addDot(int colorIn, int x, int y){
    // find the location of the dot that needs to be added
    // just add one to that dotCluster
    contents[x][y].color = colorIn;
    contents[x][y].numDots = contents[x][y].numDots + 1;
    if (contents[x][y].numDots >= contents[x][y].maxDot){
      explode(colorIn, x, y); // should be either 0 or 1 explosions - no more
      checkExplode(colorIn, x, y); // check for nearby explosions
    }
    //explode(); // should just be one explosion - of the dot
    for (int[] p : queue) {
      for (int i : p) {
        System.out.print(i + " ");
      }
      System.out.println("");
    }
    while (queue.size() > 0){
    //for (int i = 0; i < 1; i++){
    explodeQueue(colorIn); // each invocation clears the queue, then invokes checkExplode, which invokes nothing else.
                             // The body of the loop then ends, and is performed again until the queue is empty.
  }
}


  public void checkExplode(int colorIn, int x, int y){
    // checks if, after an explosion has occurred, more are necessary, and adds
    // these to the queue, but doesn't do them
	  // if (contents[x][y].numDots==contents[x][y].maxDot){
    if ( x - 1 >= 0 ){
       if (contents[x-1][y].numDots>=contents[x-1][y].maxDot){
         int[] a = {x -1, y};
         queue.add(a);
		    }
      }
    if ( x + 1 < rows ){
        if (contents[x+1][y].numDots>=contents[x+1][y].maxDot){
          int[] b = {x+1, y};
          queue.add(b);
        }
      }
    if( y-1 > -1 ){
       if (contents[x][y-1].numDots>=contents[x][y-1].maxDot){
         int[] c = {x, y-1};
         queue.add(c);
       }
     }
     if( y + 1 < columns ){
      if (contents[x][y+1].numDots>=contents[x][y+1].maxDot){
        int[] d = {x, y+1};
        queue.add(d);
      }
    }
    //for (int i = 0; i < 1; i++){
   explodeQueue(colorIn); // each invocation clears the queue, then invokes checkExplode, which invokes nothing else.
                             // The body of the loop then ends, and is performed again until the queue is empty.

   // end method
}



  public void explode(int colorIn, int x, int y){ // not invoking addDot -> only one explosion occurs per invocation
    contents[x][y].numDots = 0;
    contents[x][y].color = Text.BLUE;

    if(x-1>-1){  //if box directly above exists
      contents[x-1][y].numDots += 1;
      contents[x-1][y].color = colorIn;
    }
    if(x+1<rows){ //if box directly below exists
      contents[x+1][y].numDots += 1;
      contents[x+1][y].color = colorIn;
    }
    if(y-1>-1){ //if box to the left exists
      contents[x][y-1].numDots += 1;
      contents[x][y-1].color = colorIn;
    }
    if(y+1<columns){ //if box to the right exists
      contents[x][y+1].numDots += 1;
      contents[x][y+1].color = colorIn;
    }
  }

  public void explodeQueue(int colorIn) {
    for (int m = 0; m < queue.size(); m++){
      int[] coords = queue.get(0);
      explode(colorIn, coords[0], coords[1]); // reminder: all the explosions will be the same color, so we don't need to specify the explosion for each
                                              // should be exactly one explosion
                                              //queue.remove(m);
      queue.remove(0);
      queue.size(); // updates the size each time
      checkWin();
      if(win==true){
        break;
      }
      checkExplode(colorIn, coords[0], coords[1]);

    }
  }


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
