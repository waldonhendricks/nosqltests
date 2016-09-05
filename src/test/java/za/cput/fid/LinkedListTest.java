package za.cput.fid;

import org.junit.Test;
import za.cput.fid.datastrutctures.Person;
import za.cput.fid.datastrutctures.linkedlist.LinkedListData;
import za.cput.fid.datastrutctures.map.MapGenerateData;

import java.util.List;
import java.util.Map;

/**
 * Created by Waldon on 9/5/2016.
 */
public class LinkedListTest {
    @Test
    public void name() throws Exception {
        long start = System.currentTimeMillis();
        List<Person> getdata = new LinkedListData().getData(10000);
        for (Person person : getdata) {
            System.out.println(" The Name is "+person.getId()+" Name "+person.getName());
        }
        long end  = System.currentTimeMillis();
        long dururation = end -start;
        System.out.println( " Time Elapased "+dururation);

    }

}
