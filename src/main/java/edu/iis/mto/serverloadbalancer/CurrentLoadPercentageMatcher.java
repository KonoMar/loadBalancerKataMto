package edu.iis.mto.serverloadbalancer;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CurrentLoadPercentageMatcher extends TypeSafeMatcher<Server> {
    public static final double EPSILON = 0.01d;
    private double expectedLoadPercentage;

    public CurrentLoadPercentageMatcher(double expectedLoadPercentage) {
        this.expectedLoadPercentage = expectedLoadPercentage;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a server with load percentage of ").appendValue(expectedLoadPercentage);
    }

    @Override
    protected void describeMismatchSafely(Server item, Description description) {
        description.appendText("a server with load percentage of ").appendValue(item.getCurrentLoadPercentage());

    }

    @Override
    protected boolean matchesSafely(Server server) {
        return doubleAreEqual(expectedLoadPercentage, server.getCurrentLoadPercentage());

    }

    private boolean doubleAreEqual(double d1, double d2) {
        return d1 == d2
                || Math.abs(d1 - d2) < EPSILON;
    }



    public static Matcher<? super Server> hasCurrentLoadOf(double expectedLoadPercentage) {
        return new CurrentLoadPercentageMatcher(expectedLoadPercentage);
    }
}
