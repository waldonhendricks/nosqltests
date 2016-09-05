package za.cput.fid;


import org.junit.Assert;
import org.junit.Test;
import za.cput.fid.datastrutctures.Person;
import za.cput.fid.datastrutctures.map.MapGenerateData;

import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest  {
    @Test
    public void name() throws Exception {
        long start = System.currentTimeMillis();
        Map<String,Person> getdata = new MapGenerateData().getData(100000);
        long end  = System.currentTimeMillis();

        long dururation = end -start;
        System.out.println( " Time Elapased "+dururation);

    }


}
