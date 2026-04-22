package org.bjm.entities.repositories;

import org.bjm.entities.ForumComment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumCommentRepository extends CrudRepository<ForumComment, Integer> {

}
