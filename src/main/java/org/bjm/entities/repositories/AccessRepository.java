package org.bjm.entities.repositories;

import org.bjm.entities.Access;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRepository extends CrudRepository<Access, Integer> {

}
