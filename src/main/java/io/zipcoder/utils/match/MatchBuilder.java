package io.zipcoder.utils.match;

public class MatchBuilder {
    private String value;
    private Integer matchNumber;
    private Integer startingIndex;
    private Integer endingIndex;

    MatchBuilder setValue(String value) {
        this.value = value;
        return this;
    }

    public MatchBuilder setMatchNumber(Integer matchNumber) {
        this.matchNumber = matchNumber;
        return this;
    }

    public MatchBuilder setStartingIndex(Integer startingIndex) {
        this.startingIndex = startingIndex;
        return this;
    }

    public MatchBuilder setEndingIndex(Integer endingIndex) {
        this.endingIndex = endingIndex;
        return this;
    }

    public Match build() {
        return new Match(value, matchNumber, startingIndex, endingIndex);
    }
}