package org.bjm.entities.repositories;

import org.bjm.entities.SurveyFromForumVote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyFromForumVoteRepository extends CrudRepository<SurveyFromForumVote, Integer> {

}
