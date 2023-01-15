package dev.childer.childerserver.repositories;

import dev.childer.childerserver.models.ChildrenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildrenRepository extends JpaRepository<ChildrenModel , Long> {
}
