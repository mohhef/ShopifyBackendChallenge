package com.imagenest.repository;

import com.imagenest.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

  ImageEntity save(ImageEntity imageEntity);

  Long deleteImageEntityById(Long id);
}
