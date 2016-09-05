package za.cput.fid.datastrutctures;

/**
 * Created by Waldon on 9/5/2016.
 */
public class Person {
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
