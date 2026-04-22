package org.bjm.entities.repositories;

import org.bjm.entities.SurveyFromForum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyFromForumRepository extends JpaRepository<SurveyFromForum, Integer> {

}
