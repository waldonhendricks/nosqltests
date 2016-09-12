package za.cput.fid.datastrutctures;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

/**
 * Created by Waldon on 9/5/2016.
 */
@Table
public class Person {
    @PrimaryKeyColumn(name = "id",  ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        return getId().equals(person.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
