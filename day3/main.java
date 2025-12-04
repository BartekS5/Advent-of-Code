package day3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args){
        try (BufferedReader br = new BufferedReader(new FileReader("day3/input.txt"))) {
            String line;
            int result = 0;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                int n = line.length();
                int maxValue = 0;
                for(int i = 0; i < n; i++){
                    for(int j = i + 1; j < n; j++){
                        int first = Integer.parseInt(String.valueOf(line.charAt(i)));
                        int second = Integer.parseInt(String.valueOf(line.charAt(j)));
                        if((first * 10 + second) > maxValue){
                            maxValue = first * 10 + second;
                        }
                    }
                }
                System.out.println("Max value in line: " + maxValue);
                result += maxValue;
            }
            System.out.println("Result: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
