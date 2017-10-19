package dailyexperiment;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by iaktas on 10/18/17 at 11:26 AM.
 */

class ParseMolecule {

    public static Map<String,Integer> getAtoms(String formula) {

        Map<String,Integer> elementCounts = new TreeMap<>();
        List<String> elements = new ArrayList<>();
        Stack<String>  multipliers = new Stack<>();

        Matcher m = Pattern.compile("([A-Z][a-z])+|[A-Z]|([0-9]+)|[()]|[\\[]|[\\]]|[{}]").matcher(formula);

        while (m.find()){
            elements.add(m.group(0));
        }

        if(elements.isEmpty()){
            throw new IllegalArgumentException();
        } else{
            Collections.reverse(elements);
        }

        for (String str : elements) {
            if (str.matches("([0-9]+)|[)]|[\\]]|[}]")){
                multipliers.push(str);
            } else if(str.matches("[(]")){
                if(!multipliers.empty() && multipliers.peek().matches("[)]")){
                    multipliers.pop();
                } else{
                    throw new IllegalArgumentException();
                }
                if(!multipliers.empty() && multipliers.peek().matches("([0-9]+)")){
                    multipliers.pop();
                }
            } else if(str.matches("[\\[]")){
                if(!multipliers.empty() && multipliers.peek().matches("[\\]]")){
                    multipliers.pop();
                } else{
                    throw new IllegalArgumentException();
                }
                if(!multipliers.empty() && multipliers.peek().matches("([0-9]+)")){
                    multipliers.pop();
                }
            } else if(str.matches("[{]")){
                if(!multipliers.empty() && multipliers.peek().matches("[}]")){
                    multipliers.pop();
                } else{
                    throw new IllegalArgumentException();
                }
                if(!multipliers.empty() && multipliers.peek().matches("([0-9]+)")){
                    multipliers.pop();
                }
            } else if(str.matches("([A-Z][a-z])+|[A-Z]")){ // means element name
                elementCounts.merge(str, calcMultiplier(multipliers), (i, j) -> i+j);

                if(!multipliers.empty() && multipliers.peek().matches("([0-9]+)")){
                    multipliers.pop();
                }
            }
        }

        return elementCounts;
    }

    public static int calcMultiplier(Stack<String>  multipliers){
        OptionalInt valu = multipliers.stream().filter(s -> s.matches("([0-9]+)")).mapToInt(Integer::valueOf).reduce((s, s2) -> s*s2);
        return valu.orElse(1);
    }
}
