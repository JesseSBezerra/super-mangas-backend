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
public class MangaChapterDTO {

    private Long id;
    private Long mangaId;
    private String chapterNumber;
    private String chapterLink;
    private String chapterDate;
    private LocalDateTime createdAt;
    private Long totalPages;
}
