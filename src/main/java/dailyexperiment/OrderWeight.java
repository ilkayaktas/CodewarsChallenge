package dailyexperiment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by iaktas on 18.09.2017 at 13:36.
 */

public class OrderWeight {

    public static String orderWeight2(String string) {
        String[] split = string.split(" ");
        Arrays.sort(split, new Comparator<String>() {
            public int compare(String a, String b) {
                int aWeight = a.chars().map(c -> Character.getNumericValue(c)).sum();
                int bWeight = b.chars().map(c -> Character.getNumericValue(c)).sum();
                return aWeight - bWeight != 0 ? aWeight - bWeight : a.compareTo(b);
            }
        });
        return String.join(" ", split);
    }

    /**
     * TODO Güzel çözüm
     * @param strng
     * @return
     */
    public static String orderWeight1(String strng) {
        return
                Arrays.stream(strng.split(" "))
                        .sorted(Comparator
                                .comparing(OrderWeight::sumDigits)
                                .thenComparing(String::compareTo))
                        .collect(Collectors.joining(" "));

    }

    private static Integer sumDigits(String s) {
        return s.chars().map(Character::getNumericValue).sum();
    }


    public String orderWeight(String numbers) {
        List<Middle> list = new ArrayList<>();

        for (String number : numbers.split(" ")) {
            int i = 0;
            for (String no : number.split("")) {
                i += Integer.parseInt(no);
            }
            list.add(new Middle(i, number));
        }

        List<Middle> sss = list.stream().sorted(((o1, o2) -> o1.compare(o2))).collect(Collectors.toList());
        String result = "";
        for (Middle s : sss) {
            result += s.vas +" ";
        }

        // your code
        return result.trim();
    }

    class Middle{
        int val;
        String vas;

        public Middle(int val, String vas) {
            this.val = val;
            this.vas = vas;
        }

        public int compare(Middle m1){
            if(m1.val < this.val)return 1;
            if(m1.val == this.val && m1.vas.compareTo(this.vas) < 0) return 1;
            return -1;
        }
    }
}
