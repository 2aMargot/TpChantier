package org.mdeza.tpchantier.dao;

import org.mdeza.tpchantier.model.Operation;
import org.mdeza.tpchantier.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationDao extends JpaRepository<Operation, Integer> {
}
