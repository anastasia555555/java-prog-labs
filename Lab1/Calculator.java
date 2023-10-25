public class Calculator {
    char _a, _b;
    int _constant;

    Calculator(char a, char b, int constant) {
        
	if(constant <= 0){
          throw new ArithmeticException("Constant must be of a whole, non-zero value.");   
        }

         if(b < a){
          throw new ArithmeticException("First char must come before second char in ascii table.");   
        }
        
        _a = a;
        _b = b;
        _constant = constant;
    }
    
    float func_one(char n, char m) {

        float result = 0;
        
        for (int i = _a; i < n ; i++) {
            for (int j = _b; j < m; j++) {
                result += Float.intBitsToFloat(i % j) / Float.intBitsToFloat(i + _constant);
            }
        }
        
        return result;
    }
}