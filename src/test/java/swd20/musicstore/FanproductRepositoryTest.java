package swd20.musicstore;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd20.musicstore.domain.Fanproduct;
import swd20.musicstore.domain.FanproductRepository;
import swd20.musicstore.domain.Producttype;
import swd20.musicstore.domain.ProducttypeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FanproductRepositoryTest {

	@Autowired
	private FanproductRepository fanproductRepository;
	
	@Test
	public void createNewBook() {
		Fanproduct product1= new Fanproduct (null, "XO Logo After Hours Sweater", 41.99, "The Weeknd", "Sweater", ptype1);
		fanproductRepository.save(product1);
		assertThat(product1.getId()).isNotNull();
	}
	
	Producttype ptype1 = new Producttype("Clothing");
	
	@Autowired
	public ProducttypeRepository producttypeRepository;
	
	@Test
	public void createNewProducttype() {
		producttypeRepository.save(ptype1);
		assertThat(ptype1.getPtype_id()).isNotNull();
	}
	
	@Test
	public void findProducttypes() {
		producttypeRepository.findAll();
	}
	
	@Test
	public void deleteProducttype() {
		producttypeRepository.deleteAll();
	}
	
	@Test
	public void findFanproducts() {
		fanproductRepository.findAll();
	}
	
	@Test
	public void deleteFanproducts() {
		fanproductRepository.deleteAll();
	}
	
}
