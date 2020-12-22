package com.imagenest.dto.mapper;


import com.imagenest.dto.ImageDto;
import com.imagenest.entity.ImageEntity;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {TagMapper.class}
)
public interface ImageMapper {

  ImageEntity toImageEntity(ImageDto imageDto);

  ImageDto toImageDto(ImageEntity imageEntity);

}
