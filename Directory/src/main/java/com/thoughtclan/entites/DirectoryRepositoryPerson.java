package com.thoughtclan.entites;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryRepositoryPerson extends CrudRepository<Person, Long> {
	// Person findOneById(int id);
	List<Person> findByName(String name);

	 Person findByPhoneno(String phoneno);
}
