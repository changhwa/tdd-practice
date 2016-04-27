package io.narratage.tdd;


public class BowlingGame {

    private int[] bowls  = new int[21];
    private int currentBowl = 0;
    private int MAX_ROLL_PINS = 10;

    public void bowl(int pin) {
        bowls[currentBowl++] = pin;
    }

    public Integer getScore() {

        int score = 0;
        int round = 0;

        for (int frame = 0; frame< 10; frame++){
            if(isStrike(round)) {
                score += MAX_ROLL_PINS + strikeNextFrameScore(round);
                round++;
            } else if(isSpare(round)) {
                score += MAX_ROLL_PINS + spareNextFrameFirstScore(round);
                round += 2;
            } else {
                score += currentFrameScore(round);
                round += 2;
            }
        }

        return score;
    }

    private boolean isStrike(int round) {
        return  bowls[round] == MAX_ROLL_PINS;
    }

    private boolean isSpare(int round) {
        return currentFrameScore(round) == MAX_ROLL_PINS;
    }

    private int currentFrameScore(int round) {
        return bowls[round] + bowls[round+1];
    }

    private int strikeNextFrameScore(int round) {
        return bowls[round + 1] + bowls[round + 2];
    }

    private int spareNextFrameFirstScore(int round) {
        return bowls[round + 2];
    }
}
