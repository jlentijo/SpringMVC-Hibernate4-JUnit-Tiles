package es.begeek;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * Extends of AbstractTransactionalJUnit4SpringContextTests to rollback sql_queries
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context-test.xml" })
public abstract class TestBase extends AbstractTransactionalJUnit4SpringContextTests {  }
