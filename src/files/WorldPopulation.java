package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class WorldPopulation {

    public static void main(String[] args) {
        String fileName = "./src/files/population.txt";
        File file = new File(fileName);

        Map<Integer, Long> populationMap = new TreeMap<>();

        try (Scanner scanner = new Scanner(file);) {

            while (scanner.hasNext()) {

                String[] row = scanner.nextLine().split("\\s+");

                populationMap.put(Integer.parseInt(row[0]), Long.parseLong(row[1].replace(",","")));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Long prevPopulation = 0L;
        Integer bestYear = 0;
        Long bestDelta = 0L;
        for (Map.Entry entry : populationMap.entrySet()) {
            Long currPopulation = (Long) entry.getValue();

            //begin from second row
            if (prevPopulation != 0L) {
                if (currPopulation - prevPopulation > bestDelta) {
                    bestDelta = currPopulation - prevPopulation;
                    bestYear = (Integer) entry.getKey();
                }
            }
            prevPopulation = currPopulation;
        }

        System.out.println(bestYear);


    }
}
