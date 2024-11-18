package com.reposteria.mana.infrastructure.database.repositories;

import com.reposteria.mana.infrastructure.database.models.ERole;
import com.reposteria.mana.infrastructure.database.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
