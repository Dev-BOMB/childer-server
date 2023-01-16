package dev.childer.childerserver.repositories;

import dev.childer.childerserver.models.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageModel,Long> {
    Optional<ImageModel> findByName(String fileName);
}
