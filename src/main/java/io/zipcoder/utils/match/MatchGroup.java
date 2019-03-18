package io.zipcoder.utils.match;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

public class MatchGroup implements Iterable<Match> {
    private final Matcher matcher;
    private final List<Match> matchList;

    public MatchGroup(List<Match> matchList, Matcher matcher) {
        this.matcher = matcher;
        this.matchList = matchList;
        this.initializeMatchers();
    }

    public MatchGroup(Matcher matcher) {
        this(new ArrayList<>(), matcher);
    }

    public Match get(int index) {
        return matchList.get(index);
    }

    @Override
    public Iterator<Match> iterator() {
        return matchList.iterator();
    }

    @Override
    public String toString() {
        return matchList.toString();
    }

    private void initializeMatchers() {
        for (int i = 0; matcher.find(); i++) {
            matchList.add(new MatchBuilder()
                    .setStartingIndex(matcher.start())
                    .setEndingIndex(matcher.end())
                    .setValue(matcher.group())
                    .setMatchNumber(i)
                    .build());
        }
    }
}