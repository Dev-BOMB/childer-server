package dev.childer.childerserver.repositories;

import dev.childer.childerserver.models.DesirableConditionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DesirableConditionRepository extends JpaRepository<DesirableConditionModel, Long> {
}
