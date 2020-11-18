package swd20.musicstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProducttypeRepository extends CrudRepository<Producttype, Long> {

	List<Producttype> findByProductType(String productType);
}
