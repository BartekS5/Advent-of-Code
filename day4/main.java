package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args){
        List<String> tempList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("day4/input.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                tempList.add(line);
            }
            int accessibleCount = solve(tempList);

            System.out.println("number of Paper: " + accessibleCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int solve(List<String> tempList) {
        int rows = tempList.size();
        int cols = tempList.get(0).length();
        
        int accessibleCount = 0;
        int checkedCells = 0;
        while(checkedCells < rows * cols) {
            checkedCells = 0;
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (tempList.get(r).charAt(c) == '@') {
                        int neighborCount = countPaperNeighbors(tempList, r, c, rows, cols);

                        if (neighborCount < 4) {
                            accessibleCount++;
                            char[] chars = tempList.get(r).toCharArray();
                            chars[c] = 'x';
                            tempList.set(r, new String(chars));
                            checkedCells--;
                        }
                    }
                    checkedCells++;
                }
            }
        }
        return accessibleCount;
    }

    private static int countPaperNeighbors(List<String> tempList, int r, int c, int rows, int cols) {
        int count = 0;

        int[] rOffset = {-1, -1, -1,  0, 0,  1, 1, 1};
        int[] cOffset = {-1,  0,  1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int rIndex = r + rOffset[i];
            int cIndex = c + cOffset[i];

            if (rIndex >= 0 && rIndex < rows && cIndex >= 0 && cIndex < cols) {
                if (tempList.get(rIndex).charAt(cIndex) == '@') {
                    count++;
                }
            }
        }
        return count;
    }
}
