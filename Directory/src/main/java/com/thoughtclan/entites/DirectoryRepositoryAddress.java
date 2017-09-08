package com.thoughtclan.entites;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface DirectoryRepositoryAddress extends CrudRepository<Address, Long> {
	List<Address> findAllByPersonId(Person person);


}
