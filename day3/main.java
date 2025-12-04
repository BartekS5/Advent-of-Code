package day3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args){
        try (BufferedReader br = new BufferedReader(new FileReader("day3/input.txt"))) {
            String line;
            int result = 0;
            long totalResult = 0;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                int n = line.length();
                /* PART - 1
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
                */
                StringBuilder sb = new StringBuilder();
                int searchStartIndex = 0;
                int targetLength = 12;

                for (int i = 0; i < targetLength; i++) {
                    
                    int digitsNeededAfter = targetLength - 1 - i;
                    int lastPossibleIndex = n - 1 - digitsNeededAfter;

                    char maxDigit = '0' - 1;
                    int maxDigitIndex = -1;

                    for (int j = searchStartIndex; j <= lastPossibleIndex; j++) {
                        if (line.charAt(j) > maxDigit) {
                            maxDigit = line.charAt(j);
                            maxDigitIndex = j;
                            
                            if (maxDigit == '9') break;
                        }
                    }

                    sb.append(maxDigit);
                    searchStartIndex = maxDigitIndex + 1;
                }

                long maxValue = Long.parseLong(sb.toString());
                System.out.println("Max Value: " + maxValue);
                totalResult += maxValue;
            }
            
            System.out.println("Result: " + totalResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
