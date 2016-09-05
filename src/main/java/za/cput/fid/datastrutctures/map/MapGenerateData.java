package za.cput.fid.datastrutctures.map;

import za.cput.fid.datastrutctures.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Waldon on 9/5/2016.
 */
public class MapGenerateData {
    public Map<String,Person> getData(int number){
        Map<String,Person> data = new HashMap<String, Person>();
        for (int i = 0; i < number; i++) {
            Person p = new Person();
            p.setId(UUID.randomUUID().toString());
            p.setName("Dummy Name  "+i);
            data.put(p.getId(),p);
        }
        return data;
    }
}
