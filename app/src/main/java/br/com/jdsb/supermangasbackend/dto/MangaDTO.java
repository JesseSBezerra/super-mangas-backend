package br.com.jdsb.supermangasbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MangaDTO {

    private Long id;
    private String title;
    private String imageUrl;
    private String imagePath;
    private String mangaLink;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String synopsis;
    private String imageBase64;
    private List<String> genres;
    private Long totalChapters;
}
