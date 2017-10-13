package dailyexperiment;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by iaktas on 21.09.2017 at 16:25.
 */

public class Bowling {
    public static int bowling_score(String frames) {

        String []score = frames.split("");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(score).subList(0, 9));


        for (int i = 0; i < 9; i++) {
            if (list.get(i).equals("X")){

            } else if(list.get(i).contains("/")){

            } else{

            }
        }


        return 0;
    }

    private String getIfExist(LinkedList<String> list, int index){
        if(list.size()> index){
            return list.get(index);
        } else{
            return null;
        }
    }



    private int calculateStrike(String []score, int currentPos, boolean isStrike){
        if(score.length == currentPos)return 0;

        if (score[currentPos].contains("X")){
            return 10 + Character.getNumericValue(score[currentPos].charAt(0));
        } else if(score[currentPos].contains("/")){
            return 10 + Character.getNumericValue(score[currentPos].charAt(0));
        } else{
            return Character.getNumericValue(score[currentPos].charAt(0));
        }
    }

    private int getValue(String str){
        if(str.equals("X")){
            return 10;
        } else if(str.equals("/")){
            return 10;
        } else{
            return Character.getNumericValue(str.charAt(0));
        }

    }
}
