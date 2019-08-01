import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class TimePeriodTest {

    private TimePeriod timePeriodA;
    Date dateStartA = new Date(2018 / 10 / 10);
    Date dateEndA = new Date(2019 / 05 / 05);

    @Before
    public void setUp() throws Exception {
        timePeriodA = new TimePeriod(dateStartA, dateEndA);
    }

    @Test
    public void testAcontainsB() throws Exception {
        Date dateStartB = new Date (2018 / 11 / 11);
        Date dateEndB = new Date (2019 / 04 / 03);
        TimePeriod timePeriodB = new TimePeriod(dateStartB, dateEndB);
        Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));
    }

    @Test
    public void testBcontainsA() throws Exception {
        Date dateStartB = new Date (2018 / 10 / 02);
        Date dateEndB = new Date (2019 / 05 / 15);
        TimePeriod timePeriodB = new TimePeriod(dateStartB, dateEndB);
        Assert.assertTrue(timePeriodB.overlapsWith(timePeriodA));
    }

    @Test
    public void testBinteractA() throws Exception {
        Date dateStartB = new Date (2018 / 11 / 11);
        Date dateEndB = new Date (2019 / 05 / 06);
        TimePeriod timePeriodB = new TimePeriod(dateStartB, dateEndB);
        Assert.assertTrue(timePeriodB.overlapsWith(timePeriodA));
    }

    @Test
    public void testAinteractB() throws Exception {
        Date dateStartB = new Date (2018 / 11 / 11);
        Date dateEndB = new Date (2019 / 05 / 06);
        TimePeriod timePeriodB = new TimePeriod(dateStartB, dateEndB);
        Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));
    }

    @Test
    public void testAequalsB() throws Exception {
        Date dateStartB = new Date (2018 / 10 / 10);
        Date dateEndB = new Date (2019 / 05 / 05);
        TimePeriod timePeriodB = new TimePeriod(dateStartB, dateEndB);
        Assert.assertTrue(timePeriodB.overlapsWith(timePeriodA));
    }

    @Test
    public void testAendEqualToBstart() throws Exception {
        Date dateStartB = new Date (2019 / 05 / 05);
        Date dateEndB = new Date (2019 / 05 / 06);
        TimePeriod timePeriodB = new TimePeriod(dateStartB, dateEndB);
        Assert.assertTrue(timePeriodA.overlapsWith(timePeriodB));
    }

    @Test
    public void testAnotOverlapsWithB() throws Exception {
        Date dateStartB = new Date (2015 / 10 / 10);
        Date dateEndB = new Date (2015 / 11 / 11);
        TimePeriod timePeriodB = new TimePeriod(dateStartB, dateEndB);
        Assert.assertFalse(timePeriodA.overlapsWith(timePeriodB));
    }
}