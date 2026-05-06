package org.bjm.entities.repositories;

import java.util.List;

import org.bjm.entities.VidhanSabha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VidhanSabhaRepository extends JpaRepository<VidhanSabha, Integer> {
	
	public List<VidhanSabha> findByStateCode(String stateCode);

}
