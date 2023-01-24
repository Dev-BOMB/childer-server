package dev.childer.childerserver.repositories;

import dev.childer.childerserver.models.AssessmentFormModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentFormRepository extends JpaRepository<AssessmentFormModel , Long> {
}
