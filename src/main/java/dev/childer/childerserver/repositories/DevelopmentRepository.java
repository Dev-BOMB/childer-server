package dev.childer.childerserver.repositories;

import dev.childer.childerserver.models.DevelopmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevelopmentRepository extends JpaRepository<DevelopmentModel , Long> {
}
