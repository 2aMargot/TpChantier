package org.mdeza.tpchantier.dao;

import org.mdeza.tpchantier.model.Chantier;
import org.mdeza.tpchantier.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChantierDao extends JpaRepository<Chantier, Integer> {
}
