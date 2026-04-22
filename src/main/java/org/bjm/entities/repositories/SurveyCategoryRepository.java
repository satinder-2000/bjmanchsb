package org.bjm.entities.repositories;

import org.bjm.entities.SurveyCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyCategoryRepository extends JpaRepository<SurveyCategory, Integer> {

}
