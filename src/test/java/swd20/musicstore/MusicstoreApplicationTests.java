package swd20.musicstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd20.musicstore.web.DiscController;
import swd20.musicstore.web.DisctypeController;
import swd20.musicstore.web.FanproductController;
import swd20.musicstore.web.ProducttypeController;

@SpringBootTest
class MusicstoreApplicationTests {

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicStoreApplicationTests {
		
	@Autowired
	private DiscController discController;
	
	@Test
	public void contextLoads() {
		assertThat(discController).isNotNull();
	}
	
	@Autowired
	private DisctypeController disctypeController;
	
	@Test
	public void contextLoads2() {
		assertThat(disctypeController).isNotNull();
	}
	
	@Autowired
	private FanproductController fanproductController;
	
	@Test
	public void contextLoads3() {
		assertThat(fanproductController).isNotNull();
	}
	
	@Autowired
	private ProducttypeController producttypeController;
	
	@Test
	public void contextLoads4() {
		assertThat(producttypeController).isNotNull();
	}
	
}
}
