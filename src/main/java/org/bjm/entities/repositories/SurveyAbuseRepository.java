package org.bjm.entities.repositories;

import org.bjm.entities.SurveyAbuse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyAbuseRepository extends CrudRepository<SurveyAbuse, Integer> {

}
