public class ArrayHandler {
  int _arr_length;
  int _arr_width;
  float[][] _arr;

  ArrayHandler(float[][] arr) 
	_arr = arr;
    _arr_length = arr.length;
    
    int width = 0;
    for(int i = 0; i < _arr_length; i++){
		
      if(arr[i] == null){
        throw new NullPointerException("Subarrays cannot be null.")
      }
      
      if(arr[i].length > width){
        width = arr[i].length;
      }
    }
    _arr_width = width;
    
  }


  float[][] transpose() {
    float[][] arr_copy = new float[_arr_length][_arr_width];
    
    for (int i = 0; i < _arr_length; i++){
      for (int j = 0; j < _arr[i].length; j++){
        arr_copy[j][i] = _arr[i][j];
      }
    }
    
    return arr_copy;
  }
  
  
  float[] avr_row() {
    
    float[] result = new float[_arr_length];
    
    for (int i = 0; i < _arr_length; i++){
      float sum = 0;
      for(int j = 0; j < _arr[i].length; j++){
        sum += _arr[i][j];
      }
      result[i] = sum / _arr[i].length;
    }
    
    return result;
  }
}