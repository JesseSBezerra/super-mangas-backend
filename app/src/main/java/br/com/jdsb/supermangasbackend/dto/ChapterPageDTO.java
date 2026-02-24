package br.com.jdsb.supermangasbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChapterPageDTO {

    private Long id;
    private Long chapterId;
    private Integer pageNumber;
    private String imageUrl;
    private String imagePath;
    private LocalDateTime createdAt;
    private String imageBase64;
}
