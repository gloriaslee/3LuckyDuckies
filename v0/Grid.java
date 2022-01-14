
import java.util.ArrayList;

public class Grid{

  public static int[][] gridGen(int rows, int column){
    String[][] grid = new String[rows][column];
    for (int row = 0; row < grid.length; row++){
      for (int column = 0; column < grid[row].length; column){
        grid[row][column] = "null";
      }
    } return grid;
  }

  public static void main(String[] args){
    System.out.println(gridGen(3, 3));
  }

}
