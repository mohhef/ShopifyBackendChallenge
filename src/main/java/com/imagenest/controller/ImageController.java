package com.imagenest.controller;

import com.imagenest.exception.ExceptionType.IdNotFoundException;
import com.imagenest.service.ImageService;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/imageNest")
public class ImageController {

  private final ImageService imageService;


  @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file,
      @RequestParam String description
  ) {

    imageService.uploadImage(file, description);
    return ResponseEntity.ok(file.getOriginalFilename() + " has been uploaded");

  }

  @DeleteMapping("/{imageId}")
  @Transactional
  public ResponseEntity<String> deleteImage(@PathVariable Long imageId) {
    Long result = imageService.deleteImage(imageId);
    if (result == 1) {
      return ResponseEntity.ok("Image has been successfully deleted");
    }
    throw new IdNotFoundException("Delete of image with id " + imageId + " was unsuccessful");
  }
}
