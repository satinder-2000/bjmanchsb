package org.bjm.entities.repositories;

import org.bjm.entities.BlogAbuse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogAbuseRepository extends CrudRepository<BlogAbuse, Integer> {

}
