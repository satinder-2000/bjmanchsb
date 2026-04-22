package org.bjm.entities.repositories;

import org.bjm.entities.SurveyVote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyVoteRepository extends CrudRepository<SurveyVote, Integer> {

}
