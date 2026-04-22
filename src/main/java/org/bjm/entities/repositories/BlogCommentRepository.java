package org.bjm.entities.repositories;

import org.bjm.entities.BlogComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogCommentRepository extends CrudRepository<BlogComment, Integer> {

}
