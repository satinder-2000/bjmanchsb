package org.bjm.entities.repositories;

import org.bjm.entities.ForumAbuse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumAbuseRepository extends CrudRepository<ForumAbuse, Integer> {

}
