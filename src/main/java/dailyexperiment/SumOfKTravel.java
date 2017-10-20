package dailyexperiment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iaktas on 20.10.2017 at 10:28.
 */

public class SumOfKTravel {
    public static Integer chooseBestSum(int maxDistance, int numberOFTownToVisit, List<Integer> listOfDistances) {
        List<List> listOfSublists = new ArrayList<>();

        for (int i = 0; i < numberOFTownToVisit; i++) {
            listOfSublists.add(listOfDistances.subList(i, listOfDistances.size()));
        }

        return null;
    }
}
