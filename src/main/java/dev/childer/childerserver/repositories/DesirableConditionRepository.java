package dev.childer.childerserver.repositories;

import dev.childer.childerserver.models.DesirableConditionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DesirableConditionRepository extends JpaRepository<DesirableConditionModel, Long> {
    Optional<DesirableConditionModel> findByTopic(String text);
}
