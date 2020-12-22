package com.imagenest.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ImageEntity {

  @Id
  private int id;

  private String name;

  private String description;

  @Lob
  private byte[] data;

  @ManyToMany
  @JoinTable(
      name = "image_tag",
      joinColumns = {
          @JoinColumn(name = "image_id")
      },
      inverseJoinColumns = {
          @JoinColumn(name = "tag_id")
      }
  )
  private Set<TagEntity> tag;


}
