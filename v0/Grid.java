<<<<<<< HEAD
=======


import java.util.ArrayList;

>>>>>>> e32d37e9f2f432d109be8783cface7740bb4965e
public class Grid{

  public int rows = 0;
  public int columns = 0;
  DotCluster[][] contents = new DotCluster[rows][columns];

  public Grid(){
    contents = new DotCluster[rows][columns];
  }

  public Grid (int rowsInput, int columnInput){
    this();
    //Grid output = new Grid();
    rows = rowsInput;
    columns = columnInput;
    contents = new DotCluster[rowsInput][columnInput];
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < columns; j++){
          contents[i][j] = new DotCluster(0, 34);
          //changing maxDot for special DotClusters:
          if(i==0||i==rows-1){
            if(j==0||j==columns-1){
              contents[i][j].maxDot=2;
            }
          }else if(i==0||i==rows-1||j==0||j==columns-1){
            contents[i][j].maxDot = 3;
          }else{
            contents[i][j].maxDot = 4;
          }
      }
    }
  }

  public void addDot(int colorIn, int x, int y){
    // find the location of the dot that needs to be added
    // just add one to that dotCluster
    contents[x][y].numDots = contents[x][y].numDots + 1;
    contents[x][y].color = colorIn;
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

  public static void main(String[] args){
    Grid richard = new Grid(12, 18);
    System.out.println(richard);
<<<<<<< HEAD
  }

}
=======
  }

}

>>>>>>> e32d37e9f2f432d109be8783cface7740bb4965e
