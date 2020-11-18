package swd20.musicstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DisctypeRepository extends CrudRepository<Disctype, Long> {

	List<Disctype> findByDiscType(String discType);
}
