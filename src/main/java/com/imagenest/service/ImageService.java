package com.imagenest.service;

import com.imagenest.dto.ImageDto;
import com.imagenest.dto.mapper.ImageMapper;
import com.imagenest.entity.ImageEntity;
import com.imagenest.exception.ExceptionType.IoException;
import com.imagenest.repository.ImageRepository;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Component
@RequiredArgsConstructor
public class ImageService {

  private final ImageRepository imageRepository;
  private final ImageMapper imageMapper;

  public List<ImageDto> retrieveImages() {
    return imageMapper.toImageDtos(imageRepository.findAll());
  }

  public ImageDto uploadImage(MultipartFile file, String description) {

    ImageDto imageDto = new ImageDto(file, description);
    String fileName = StringUtils.clean(file.getOriginalFilename());
    try {
      byte[] data = file.getBytes();
      ImageEntity imageEntity = imageMapper.toImageEntity(imageDto);
      imageEntity.setName(fileName);
      imageEntity.setData(data);
      return imageMapper.toImageDto(imageRepository.save(imageEntity));
    } catch (IOException exception) {
      throw new IoException("Error occurred while getting bytes");
    }

  }

  public Long deleteImage(Long imageId) {
    return imageRepository.deleteImageEntityById(imageId);
  }
}
