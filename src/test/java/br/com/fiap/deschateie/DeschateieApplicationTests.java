package br.com.fiap.deschateie;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeschateieApplicationTests {

	@Test
	public void contextLoads() {
		Long n1 = new Long(0);
		Long n2 = new Long(0);
		assertEquals(n1, n2);
	}

}
