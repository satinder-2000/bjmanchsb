package org.bjm.entities.repositories;

import org.bjm.entities.LokSabha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LokSabhaRepository extends JpaRepository<LokSabha, Integer> {

}
