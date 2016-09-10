package za.cput.fid.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import za.cput.fid.config.CassandraConfig;
import za.cput.fid.datastrutctures.Person;
import za.cput.fid.datastrutctures.linkedlist.LinkedListData;
import za.cput.fid.repository.cassandra.PersonRepository;

import java.util.List;

/**
 * Created by hashcode on 2016/09/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CassandraConfig.class)
public class PersonRepositoryTest {
    private static final Log LOGGER = LogFactory.getLog(PersonRepositoryTest.class);

    public static final String KEYSPACE_CREATION_QUERY = "CREATE KEYSPACE IF NOT EXISTS testKeySpace WITH replication = { 'class': 'SimpleStrategy', 'replication_factor': '3' };";

    public static final String KEYSPACE_ACTIVATE_QUERY = "USE testKeySpace;";

    public static final String DATA_TABLE_NAME = "book";

    @Autowired
    private PersonRepository personRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testCreate() throws Exception {
        List<Person> getdata = new LinkedListData().getData(1);
        for (Person person : getdata) {
            personRepository.save(person);
        }

    }
}
