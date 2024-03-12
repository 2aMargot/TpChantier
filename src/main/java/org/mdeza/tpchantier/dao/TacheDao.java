package org.mdeza.tpchantier.dao;

import org.mdeza.tpchantier.model.Tache;
import org.mdeza.tpchantier.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacheDao extends JpaRepository<Tache, Integer> {
}
