import java.util.*;

public class Main {
  
  public static void main(String[] args) {
  // O1 = "+"
  // C5 = B^T
  // C7 = float
  // C11 = find avg in each row
  
  float[][] arr = { {1, 2}, {2, 3}, {1, 2, 3} };
  
  ArrayHandler handler = new ArrayHandler(arr);
  
  float[][] arr1 = handler.transpose();
  
  System.out.println(Arrays.deepToString(arr1));
  
  float[] arr2 = handler.avr_row();
  
  System.out.println(Arrays.toString(arr2));
  } 
}
