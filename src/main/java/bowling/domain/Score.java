package bowling.domain;

import java.util.Objects;

public class Score {
    private static final int MAX_SCORE = 10;

    private int score;
    private final int leftBonusCount;

    public Score(int score, int leftBonusCount) {
        this.score = score;
        this.leftBonusCount = leftBonusCount;
    }

    public static Score ofMiss(int score) {
        return new Score(score, 0);
    }

    public static Score ofSpare() {
        return new Score(MAX_SCORE, 1);
    }

    public static Score ofStrike() {
        return new Score(MAX_SCORE, 2);
    }

    public Score bowl(int countOfPins) {
        return new Score(score += countOfPins, leftBonusCount - 1);
    }

    public int getScore() {
        if (!canCalculateScore()) {
            throw new IllegalArgumentException();
        }
        return this.score;
    }

    public boolean canCalculateScore() {
        return leftBonusCount == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Score)) return false;
        Score score1 = (Score) o;
        return score == score1.score &&
                leftBonusCount == score1.leftBonusCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, leftBonusCount);
    }
}
