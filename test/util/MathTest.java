package util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathTest {

    @Test
    public void OnePoint123ShouldBeRoundedToOnePoint10() throws Exception {
        assertEquals(1.10, util.Math.roundTo0_05(1.123), 0);
    }
}
