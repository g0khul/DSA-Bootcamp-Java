public class Dummy {
    public static int encryptNumbers(int[] Numbers, int N) {
        int sum = 0;
        
        for (int i = 0; i < N; i++) {
            if (Numbers[i] == -1) {
                Numbers[i] = findBitEvenNumber(Numbers[i - 1]);
            }
            
            sum += Numbers[i];
        }
        
        return sum;
    }
    
    private static int findBitEvenNumber(int previousNumber) {
        int num = previousNumber + 1;
        
        while (!isBitEven(num)) {
            num++;
        }
        
        return num;
    }
    
    private static boolean isBitEven(int number) {
        int bitPosition = 0;
        
        while (number > 0) {
            int bit = number & 1;
            
            if (bitPosition % 2 != 0 && bit != 0) {
                return false;
            }
            
            number = number >> 1;
            bitPosition++;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        int[] Numbers = {34, -1, -1, -1};
        int N = 4;
        
        int minimumSum = encryptNumbers(Numbers, N);
        System.out.println(minimumSum);
    }
}
