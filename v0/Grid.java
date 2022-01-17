<<<<<<< HEAD

import java.util.ArrayList;

public class Grid{

  private int row = 0;
  private int column = 0;
  DotCluster[][] contents = new DotCluster[row][column];

  public Grid(){
    contents = new DotCluster[row][column];
  }

  public Grid (int rowsInput, int columnInput){
    this();
    //Grid output = new Grid();
    row = rowsInput;
    column = columnInput;
    contents = new DotCluster[rowsInput][columnInput];
    for (int i = 0; i < row; i++){
      for (int j = 0; j < column; j++){
          contents[i][j] = new DotCluster(1, 32);
      }
    }
  }

  public String toString(){
    String output = "";
    for (DotCluster[] row: contents){
      for (DotCluster i : row){
        output += i.toString() + " ";
      }
      output += "\n";
    }
    return output;
  }

  public static void main(String[] args){
    // Grid bob = new Grid();
    Grid richard = new Grid(3, 3);
    // System.out.println(bob);
    System.out.println(richard);
  }

}

// class Inner{
//   public Inner{
//
//   }
//
// }
=======

import java.util.ArrayList;

public class Grid{

  private int row = 0;
  private int column = 0;
  DotCluster[][] contents = new DotCluster[row][column];

  public Grid(){
    contents = new DotCluster[row][column];
  }

  public Grid (int rowsInput, int columnInput){
    this();
    //Grid output = new Grid();
    row = rowsInput;
    column = columnInput;
    contents = new DotCluster[rowsInput][columnInput];
    for (int i = 0; i < row; i++){
      for (int j = 0; j < column; j++){
          contents[i][j] = new DotCluster(1, 32);
      }
    }
  }

  public String toString(){
    String output = "";
    for (DotCluster[] row: contents){
      for (DotCluster i : row){
        output += i.toString() + " ";
      }
      output += "\n";
    }
    return output;
  }

  public static void main(String[] args){
    // Grid bob = new Grid();
    Grid richard = new Grid(3, 3);
    // System.out.println(bob);
    System.out.println(richard);
  }

}
>>>>>>> 392792f3f0f43ec16009aa781a4885544f9d3f10
