package dailyexperiment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by iaktas on 21.09.2017 at 16:25.
 */
public class BowlingTest {
    @Test
    void bowling_score() {
        // assertEquals("expected", "actual");
        System.out.println("Maybe this bowler should put bumpers on...\n ");
        assertEquals(20, Bowling.bowling_score("11 11 11 11 11 11 11 11 11 11"));

        assertEquals(29, Bowling.bowling_score("1/ 11 11 11 11 11 11 11 11 11"));

        System.out.println("Woah! Perfect game!");
        assertEquals(300, Bowling.bowling_score("X X X X X X X X X XXX"));
    }

}