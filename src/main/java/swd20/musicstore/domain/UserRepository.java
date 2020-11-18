package swd20.musicstore.domain;

import org.springframework.data.repository.CrudRepository;

import swd20.musicstore.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
}
