package de.quinscape.domainqlstarter;

import de.quinscape.domainqlstarter.runtime.DomainqlstarterApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {
	DomainqlstarterApplication.class
})
public class DomainqlstarterApplicationTests {

	@Test
	public void contextLoads() {
	}

}
