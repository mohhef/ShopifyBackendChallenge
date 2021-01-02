package com.imagenest.repository;

import com.imagenest.entity.ImageEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

  List<ImageEntity> findAll();

  ImageEntity save(ImageEntity imageEntity);

  Long deleteImageEntityById(Long id);
}
