package dailyexperiment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by iaktas on 10/18/17 at 11:26 AM.
 */
@RunWith(Parameterized.class)
public class ParseMoleculeTest {
    @Test
    public void calcMultiplier() throws Exception {

        Stack<String> stack = new Stack<>();
        stack.addAll(Arrays.asList("2",")","3","4","]"));

        assertEquals(24, ParseMolecule.calcMultiplier(stack));

    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList( new Object[][] {
                {Arrays.asList("As", "B", "Cu", "Be", "C", "Co", "O"),
                        Arrays.asList(2, 8, 5, 16, 44, 24, 48),
                        "As2{Be4C5[BCo3(CO2)3]2}4Cu5",
                        "wierd"},
                {Arrays.asList("C", "H", "O"),
                        Arrays.asList(6, 12, 6),
                        "C6H12O6",
                        "glucose"},
                {Arrays.asList("H", "O"),
                        Arrays.asList(2, 1),
                        "H2O",
                        "water"},
                {Arrays.asList("Mg", "H", "O"),
                        Arrays.asList(  1,   2,   2 ),
                        "Mg(OH)2",
                        "magnesium hydroxide"},

                {Arrays.asList("K", "O", "N", "S"),
                        Arrays.asList( 4,   14,  2,   4 ),
                        "K4[ON(SO3)2]2",
                        "Fremy's salt"},
        });
    }

    private Map<String,Integer> expected;
    private String formula, name;

    public ParseMoleculeTest (List<String> atoms, List<Integer> nums, String formula, String name) {
        Map<String,Integer> exp = new HashMap<String,Integer>();
        for (int i = 0 ; i < atoms.size() ; i++) exp.put(atoms.get(i), nums.get(i));

        this.expected = exp;
        this.formula = formula;
        this.name = name;
    }

    @Test
    public void testMolecule() {
        System.out.println(expected);
        assertEquals(String.format("Should parse %s: %s", name, formula), expected, ParseMolecule.getAtoms(formula));
    }
}