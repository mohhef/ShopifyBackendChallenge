package com.imagenest.controller;

import com.imagenest.dto.ImageDto;
import com.imagenest.exception.ExceptionType.IdNotFoundException;
import com.imagenest.service.ImageService;
import java.util.Base64;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping("/imagenest")
public class ImageController {

  private final ImageService imageService;

  @GetMapping()
  public String retrieveImages(Model model) {
    List<ImageDto> imageDtos = imageService.retrieveImages();
    for (ImageDto imageDto : imageDtos) {
      imageDto.setImageData(Base64.getEncoder().encodeToString(imageDto.getData()));
    }
    model.addAttribute("images", imageDtos);
    return "imagenest";
  }

  @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public String uploadImage(@RequestParam("file") MultipartFile file,
      @RequestParam("description") String description
  ) {

    imageService.uploadImage(file, description);
    return "redirect:/imagenest";

  }

  @DeleteMapping("/{imageId}")
  @Transactional
  public String deleteImage(@PathVariable Long imageId) {
    Long result = imageService.deleteImage(imageId);
    if (result == 1) {
      return "redirect:/imagenest";
    }
    throw new IdNotFoundException("Delete of image with id " + imageId + " was unsuccessful");
  }
}
