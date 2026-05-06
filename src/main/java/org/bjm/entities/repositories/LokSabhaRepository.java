package org.bjm.entities.repositories;

import java.util.List;

import org.bjm.entities.LokSabha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LokSabhaRepository extends JpaRepository<LokSabha, Integer> {
	
	public List<LokSabha> findByStateCode(String stateCode);

}
