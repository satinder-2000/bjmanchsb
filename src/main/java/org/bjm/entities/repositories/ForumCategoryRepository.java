package org.bjm.entities.repositories;

import org.bjm.entities.ForumCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumCategoryRepository extends CrudRepository<ForumCategory, Integer> {

}
