import org.junit.Assert;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TrackerTest {


    public Tracker tracker = new Tracker();

   /* tracker.attach("apibox");
    >> "apibox:1"
        tracker.attach("apibox");
>> "apibox:2"
        tracker.detach("apibox:1");
tracker.attach("apibox");
>> "apibox:1"
        tracker.attach("apibox");
>> "apibox:3"
        tracker.detach("apibox:2");
tracker.attach("apibox");
>> "apibox:2"
        tracker.attach("sitebox");
>> "sitebox:1"

        tracker.attach("apibox");
tracker.attach("apibox");
tracker.attach("apibox");
tracker.attach("apibox");
>> "apibox:4"

        tracker.detach("apibox:2");

tracker.attach("apibox");

    */

    public TrackerTest() {


    }

    @org.junit.jupiter.api.Test
    void attach() {
        Assert.assertEquals("apibox:1", tracker.attach("apibox"));
        Assert.assertEquals("apibox:2", tracker.attach("apibox"));
        Assert.assertEquals("apibox:3", tracker.attach("apibox"));
        tracker.detach("apibox:1");
        tracker.detach("apibox:3");
        Assert.assertEquals("apibox:1", tracker.attach("apibox"));
        Assert.assertEquals("apibox:3", tracker.attach("apibox"));
        Assert.assertEquals("apibox:4", tracker.attach("apibox"));
    }

}