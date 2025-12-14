package day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class main {
    public static void main(String[] args){
        List<long[]> inputRanges = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("day5/inputRanges.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("[-,]+");
                long start = Long.parseLong(parts[0]);
                long end = Long.parseLong(parts[1]);
                inputRanges.add(new long[]{start, end});
            }

            inputRanges.sort(Comparator.comparingLong(a -> a[0]));

            List<long[]> merged = new ArrayList<>();
            long[] currentRange = inputRanges.get(0);

            for (int i = 1; i < inputRanges.size(); i++) {
                long[] nextRange = inputRanges.get(i);

                if (nextRange[0] <= currentRange[1]) {
                    currentRange[1] = Math.max(currentRange[1], nextRange[1]);
                } else {
                    merged.add(currentRange);
                    currentRange = nextRange;
                }
            }
            merged.add(currentRange);

            long totalIds = 0;
            for (long[] range : merged) {
                totalIds += (range[1] - range[0] + 1);
            }

            System.out.println("ids: " + totalIds);

        } catch (Exception e) {
            e.printStackTrace();
        }

            /* Part 1 solution
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
            */
    }
}
