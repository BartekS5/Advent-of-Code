package day2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class main {
    public static void main(String[] args){
        try (BufferedReader br = new BufferedReader(new FileReader("day2/input.txt"))) {
            String line = br.readLine();

            long[] numbers = Arrays.stream(line.split("[-,]+"))
                              .mapToLong(Long::parseLong)
                              .toArray();
            long invalidSum = 0;
            /* PART - 1
            for(int j = 0; j < numbers.length; j += 2) {
                System.out.println("Checking range: " + numbers[j] + " to " + numbers[j + 1]);
                for(long i = numbers[j]; i <= numbers[j + 1]; i++) {
                    String numStr = Long.toString(i);
                    int lenHalf = numStr.length() / 2;
                    long devisor = (long) Math.pow(10, lenHalf);

                    if((i % devisor) == (i / devisor)){
                        invalidSum += i;
                    }
                }
            }
             */
            for(int j = 0; j < numbers.length; j += 2) {
                System.out.println("Checking range: " + numbers[j] + " to " + numbers[j + 1]);
                for(long i = numbers[j]; i <= numbers[j + 1]; i++) {
                    String numStr = Long.toString(i);
                    if (numStr.matches("(.+)\\1+")) {
                        invalidSum += i;
                    }
                }
            }
            
            System.out.println("Result: " + invalidSum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
