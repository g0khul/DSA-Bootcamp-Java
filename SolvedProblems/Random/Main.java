public class Main {
    public static int encryptinput1(int[] input1, int N) {
        int sum = 0;
        
        for (int i = 0; i < N; i++) {
            if (input1[i] == -1) {
                int num = findBitEvenNumber(input1, i);
                input1[i] = num;
            }
            
            sum += input1[i];
        }
        
        return sum;
    }
    
    private static int findBitEvenNumber(int[] input1, int index) {
        int minNumber = input1[index - 1] + 1;
        
        while (!isBitEven(minNumber)) {
            minNumber++;
        }
        
        return minNumber;
    }
    
    private static boolean isBitEven(int number) {
        int bitPosition = 1;
        
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
        int[] input1 = {34,-1,-1,-1};
        int N = 4;
        
        int minimumSum = encryptinput1(input1, N);
        System.out.println(minimumSum);
    }
}
