package za.cput.fid.repository.cassandra;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import za.cput.fid.datastrutctures.Person;

/**
 * Created by hashcode on 2016/09/10.
 */
@Repository
public interface PersonRepository  extends CassandraRepository<Person> {
}
