package dev.childer.childerserver.repositories;

import dev.childer.childerserver.models.EstimateModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstimateRepository extends JpaRepository<EstimateModel,Long> {
}
