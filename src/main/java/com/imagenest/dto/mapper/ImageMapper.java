package com.imagenest.dto.mapper;


import com.imagenest.dto.ImageDto;
import com.imagenest.entity.ImageEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring"
)
public interface ImageMapper {

  ImageEntity toImageEntity(ImageDto imageDto);

  ImageDto toImageDto(ImageEntity imageEntity);

  List<ImageDto> toImageDtos(List<ImageEntity> imageEntity);
}
