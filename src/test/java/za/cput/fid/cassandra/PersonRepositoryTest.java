package za.cput.fid.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cassandra.core.cql.CqlIdentifier;
import org.springframework.data.cassandra.core.CassandraAdminOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import za.cput.fid.config.CassandraConfig;
import za.cput.fid.datastrutctures.Person;
import za.cput.fid.datastrutctures.linkedlist.LinkedListData;
import za.cput.fid.repository.cassandra.PersonRepository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by hashcode on 2016/09/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CassandraConfig.class)
public class PersonRepositoryTest {
    private static final Log LOGGER = LogFactory.getLog(PersonRepositoryTest.class);

    public static final String KEYSPACE_CREATION_QUERY = "CREATE KEYSPACE IF NOT EXISTS nosqltests WITH replication = { 'class': 'SimpleStrategy', 'replication_factor': '1' };";

    public static final String KEYSPACE_ACTIVATE_QUERY = "USE nosqltests;";

    public static final String DATA_TABLE_NAME = "person";

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CassandraAdminOperations adminTemplate;

    @Before
    public void setUp() throws Exception {
        final Cluster cluster = Cluster.builder().addContactPoints("172.17.0.2").withPort(9042).build();
        LOGGER.info("Server Started at 172.17.0.2:9142... ");
        final Session session = cluster.connect();
        session.execute(KEYSPACE_CREATION_QUERY);
        session.execute(KEYSPACE_ACTIVATE_QUERY);
        LOGGER.info("KeySpace created and activated.");
        adminTemplate.createTable(true, CqlIdentifier.cqlId(DATA_TABLE_NAME), Person.class, new HashMap<String, Object>());

    }

    @Test
    public void testCreate() throws Exception {
        List<Person> getdata = new LinkedListData().getData(1);
        for (Person person : getdata) {
            personRepository.save(person);
        }

    }
}
