package com.imagenest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageDto {


  private Long id;
  private byte[] data;

  private MultipartFile file;

  private String description;
  private String imageData;

  public ImageDto(MultipartFile file, String description) {
    this.file = file;
    this.description = description;
  }


}
