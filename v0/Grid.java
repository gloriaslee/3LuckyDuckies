
import java.util.ArrayList;

public class Grid{

  int row = 0, column = 0;
  String[][] grid = new String[row][column];

  public Grid(){
    System.out.println(grid);
  }

  public Grid (int rowsInput, int columnInput){
    grid = new String[rowsInput][columnInput];
    for (row = 0; row < grid.length; row++){
      for (column = 0; column < grid[row].length; column++){
          grid[row][column] = ". ";
      }
    } System.out.println(grid);
  }

  public String toString(){
    return this.grid;
  }

  public static void main(String[] args){
    Grid bob = new Grid();
    Grid richard = new Grid(3, 3);
    System.out.println(bob);
    System.out.prinln(richard);
  }

}

// class Inner{
//   public Inner{
//
//   }
//
// }
