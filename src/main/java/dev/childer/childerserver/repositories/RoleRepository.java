package dev.childer.childerserver.repositories;

import dev.childer.childerserver.models.Enums.ERole;
import dev.childer.childerserver.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
    Optional<RoleModel> findByName(ERole name);
}
