package com.imagenest.controller;

import com.imagenest.service.ImageService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class ImageController {

  private final ImageService imageService;


  @PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file,
      @RequestParam String description
  ) throws IOException {

    imageService.uploadImage(file, description);
    return ResponseEntity.ok(file.getOriginalFilename() + " has been uploaded");

  }
}
