/**
 * Task 2056 SGU (popular words)
 *
 * @author Hin7
 * @version 1.1 10.03.2020
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PopularWords { //when send to SGU, rename class to Solution
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(Paths.get("input.txt"), "UTF-8");
            PrintWriter out = new PrintWriter("output.txt", "UTF-8");
            Map<String, Integer> oftenWords = new TreeMap<>();
            Integer maxOftenCount = 0;
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.length() > 0) {
                        Integer oftenV = oftenWords.merge(word.toLowerCase().trim(), 1, Integer::sum);
                        if (maxOftenCount.compareTo(oftenV) < 0)
                            maxOftenCount = oftenV;
                    }
                }
            }
            if (!oftenWords.isEmpty()) {
                //System.out.println(maxOftenCount);
                for (String word : oftenWords.keySet()) {
                    if (oftenWords.get(word).equals(maxOftenCount))
                        //System.out.println(word);
                        out.println(word);
                }
                out.close();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
