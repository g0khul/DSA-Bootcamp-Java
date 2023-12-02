package CPfor100Days.Recursion;

public class Main{
    public static void main(String[] args) {
        int limit = (int) Math.sqrt(1234412); 
        int count = 0;
        
        for (int i = 1; i <= limit; i++) {
            int square = i * i; 
            
            if (square <= 112) {
                count++;
            }
        }

        System.out.println(count + " : " + (int) (Math.sqrt(1234412)));
    }
}