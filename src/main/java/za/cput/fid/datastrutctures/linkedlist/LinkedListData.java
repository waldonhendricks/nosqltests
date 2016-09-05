package za.cput.fid.datastrutctures.linkedlist;

import za.cput.fid.datastrutctures.Person;

import java.util.*;

/**
 * Created by Waldon on 9/5/2016.
 */
public class LinkedListData {
    public List<Person> getData(int number) {
        List<Person> data = new ArrayList<Person>();
        for (int i = 0; i < number; i++) {
            Person p = new Person();
            p.setId(UUID.randomUUID().toString());
            p.setName("Dummy Name  " + i);
            data.add(p);
        }
        return data;
    }

}
