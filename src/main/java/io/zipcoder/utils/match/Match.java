package io.zipcoder.utils.match;

public class Match {
    private String value;
    private Integer matchNumber;
    private Integer startingIndex;
    private Integer endingIndex;

    Match(String value, Integer matchNumber, Integer startingIndex, Integer endingIndex) {
        this.value = value;
        this.matchNumber = matchNumber;
        this.startingIndex = startingIndex;
        this.endingIndex = endingIndex;
    }

    public String getValue() {
        return value;
    }

    public Integer getMatchNumber() {
        return matchNumber;
    }

    public Integer getStartingIndex() {
        return startingIndex;
    }

    public Integer getEndingIndex() {
        return endingIndex;
    }

    @Override
    public String toString() {
        return "Match{" +
                "value='" + value + '\'' +
                ", matchNumber=" + matchNumber +
                ", startingIndex=" + startingIndex +
                ", endingIndex=" + endingIndex +
                '}';
    }
}
