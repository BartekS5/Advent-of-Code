package day1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args){
        try (BufferedReader br = new BufferedReader(new FileReader("day1/input.txt"))) {
            String line;
            int start = 50;
            int result = 0;

            while ((line = br.readLine()) != null) {
                System.out.println(line);

                char directionChar = line.charAt(0);

                int steps = Integer.parseInt(line, 1, line.length(), 10);
                int numrotations = steps / 100;
                result += numrotations;
                int remainder = steps % 100;
                if (remainder > 0) {
                    int distanceToZero = 0;

                    if (directionChar == 'R') {
                        distanceToZero = (start == 0) ? 100 : (100 - start);
                    } else {
                        distanceToZero = (start == 0) ? 100 : start;
                    }

                    if (remainder >= distanceToZero) {
                        result++;
                    }
                }

                int direction = (directionChar == 'R') ? 1 : -1;
                start = (start + (direction * remainder)) % 100;
                if (start < 0) start += 100;
            }
            System.out.println("Result: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
}
