package com.imagenest.controller;

import com.imagenest.dto.ImageDto;
import com.imagenest.service.ImageService;
import java.io.IOException;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class ImageController {

  private final ImageService imageService;

  @PostMapping("/test")
  public ResponseEntity<String> testImage(@RequestParam("file") MultipartFile file) {
    return ResponseEntity.ok("ay");
  }

  @PostMapping("/upload")
  public ResponseEntity<ImageDto> uploadImage(@RequestParam("file") MultipartFile file,
      @RequestBody @Valid ImageDto imageDto)
      throws IOException {
    ImageDto imageDto1 = imageService.uploadImage(imageDto, file);
    return ResponseEntity.ok(imageDto1);
  }

}
