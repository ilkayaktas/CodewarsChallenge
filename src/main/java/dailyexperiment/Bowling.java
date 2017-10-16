package dailyexperiment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by iaktas on 21.09.2017 at 16:25.
 */

public class Bowling {

    public static int bowling_score(String frames) {

        String[] score = frames.split(" ");
        int total = 0;

        List<BowlingString> frameList = Arrays.stream(score).map(BowlingString::new).collect(Collectors.toList());

        for (int i = 0; i < frameList.size() - 1; i++) {
            BowlingString currentFrame = frameList.get(i);

            if(currentFrame.isSpare()){
                total += currentFrame.getValue()+ frameList.get(i+1).getFirstRoll();
            } else if(currentFrame.isStrike()){
                if(frameList.get(i+1).rollCount == 1){
                    total += currentFrame.getValue() + frameList.get(i+1).getSecondRoll() + frameList.get(i+2).getFirstRoll();
                } else{
                    total += currentFrame.getValue() + frameList.get(i+1).getSecondRoll();
                }
            } else{
                total += currentFrame.getValue();
            }
        }

        total += frameList.get(frameList.size()-1).getValue();

        return total;

    }

    private static int other_solution(String frames){
        String[] fArr = frames.split(" ");
        int score = 0;

        for (int i = 0 ; i < fArr.length ; i++) {
            if (fArr[i].matches("X|[0-9]/")) {
                if (i < 9) fArr[i] = Arrays.stream(fArr, i, fArr.length)
                        .collect(Collectors.joining(""))
                        .substring(0, 3);
            }
            score += fArr[i].replaceAll("[0-9]/","X")
                    .chars()
                    .map( n -> !Character.isDigit((char) n) ? 10 : Integer.valueOf(Character.toString((char) n)))
                    .sum();
        }
        return score;
    }

    static class BowlingString {
        final String frame;
        final int rollCount;

        BowlingString(String frame) {
            this.frame = frame;
            rollCount = frame.split("").length;
        }

        int getValue() {
            return calculate(rollCount);
        }

        int getFirstRoll() {
            return calculate(1);
        }

        int getSecondRoll(){
            return calculate(2);
        }

        private int calculate(int rollCount){
            int total = 0, prev = 0;
            for (int i = 0; i < rollCount && i < this.rollCount; i++) {
                if(frame.charAt(i) == 'X'){
                    total += 10;
                    prev = 10;
                }
                else if(frame.charAt(i) == '/'){
                    total = total - prev + 10;
                    prev = 10;
                } else{
                    total += frame.charAt(i) -48;
                    prev = frame.charAt(i) -48;
                }
            }
            return total;
        }

        boolean isSpare(){
            return frame.contains("/");
        }

        boolean isStrike(){
            return frame.equals("X");
        }
    }
}
