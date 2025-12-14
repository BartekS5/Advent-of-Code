package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class main {
    public static void main(String[] args){
        try (BufferedReader br1 = new BufferedReader(new FileReader("day5/inputRanges.txt"))) {
            String line;
            long[] ranges = new long[0];
            int index = 0;
             while ((line = br1.readLine()) != null) {
                long[] range = Arrays.stream(line.split("[-,]+"))
                              .mapToLong(Long::parseLong)
                              .toArray();
                long[] newRanges = Arrays.copyOf(ranges, ranges.length + range.length);
                System.arraycopy(range, 0, newRanges, index, range.length);
                ranges = newRanges;
                index += range.length;
             }
            
            System.out.println("Numbers read: " + Arrays.toString(ranges));

            try (BufferedReader br2 = new BufferedReader(new FileReader("day5/inputId.txt"))) {
                String idLine;
                long validCount = 0;

                while ((idLine = br2.readLine()) != null) {
                    long id = Long.parseLong(idLine);

                    for(int j = 0; j < ranges.length; j += 2) {
                        if(id >= ranges[j] && id <= ranges[j + 1]) {
                            validCount++;
                            break;
                        }
                    }
                }

                System.out.println("Result: " + validCount);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
