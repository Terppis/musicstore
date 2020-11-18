package swd20.musicstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd20.musicstore.domain.Disc;
import swd20.musicstore.domain.DiscRepository;
import swd20.musicstore.domain.Disctype;
import swd20.musicstore.domain.DisctypeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DiscRepositoryTest {

	@Autowired
	private DiscRepository discRepository;
	
	@Test
	public void createNewBook() {
		Disc disc = new Disc (null, "After Hours", "The Weeknd", 2020, 37.99, "R&B", 14, type1);
		discRepository.save(disc);
		assertThat(disc.getId()).isNotNull();
	}
	
	Disctype type1 = new Disctype("LP");
	
	@Autowired
	public DisctypeRepository disctypeRepository;
	
	@Test
	public void createNewDisctype() {
		disctypeRepository.save(type1);
		assertThat(type1.getType_id()).isNotNull();
	}
	
	@Test
	public void findDisctypes() {
		disctypeRepository.findAll();
	}
	
	@Test
	public void deleteCategory() {
		disctypeRepository.deleteAll();
	}
	
	@Test
	public void findDiscs() {
		discRepository.findAll();
	}
	
	@Test
	public void deleteDiscs() {
		discRepository.deleteAll();
	}
	
}
