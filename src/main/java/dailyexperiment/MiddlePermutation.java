package dailyexperiment;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by aselsan on 17.11.2017 at 11:24.
 */

public class MiddlePermutation {
    public volatile static Set<String> permutations;
    public static ExecutorService service = Executors.newFixedThreadPool(20);
    public volatile static Collection<Future<?>> futures = new ConcurrentLinkedQueue<>();

    public static String findMidPerm(String strng) {

        permutations = new TreeSet<>();
        generatePermutations("", Arrays.stream(strng.split("")).sorted(Comparator.naturalOrder()).reduce("", String::concat) );

        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>(permutations).get((permutations.size()+1)/2-1);
    }

    private static void generatePermutations(String generatedString, String restOfString){
        int length = restOfString.length();
        if(length == 0){
            permutations.add(generatedString);
        }

        for (int i = 0; i < length; i++) {
            String nextChar = String.valueOf(restOfString.charAt(i));
            String tmpgeneratedString = generatedString; // backup
            String tmprestOfString = restOfString; // backup

            generatedString = generatedString.concat( nextChar ); // append next character to end of generated string
            restOfString = restOfString.replace(nextChar, ""); // remove next character from

            String finalRestOfString = restOfString;
            String finalGeneratedString = generatedString;
            futures.add(service.submit(() -> generatePermutations(finalGeneratedString, finalRestOfString)));

            generatedString = tmpgeneratedString; // restore
            restOfString = tmprestOfString; // restore
        }
    }
}
