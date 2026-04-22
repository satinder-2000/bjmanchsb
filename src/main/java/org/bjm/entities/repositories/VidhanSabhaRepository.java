package org.bjm.entities.repositories;

import org.bjm.entities.VidhanSabha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VidhanSabhaRepository extends JpaRepository<VidhanSabha, Integer> {

}
