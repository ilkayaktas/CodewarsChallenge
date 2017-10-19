package dailyexperiment;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by ilkay on 20/10/2017 at 00:17.
 */

public class StringVowelCapitalize {
    public static String swap(String str){

        Optional<String> op = Stream.of(str.split("")).map(s -> s.matches("[aeiou]")?s.toUpperCase():s).reduce(String::concat);

        return op.orElse("");
    }
}
