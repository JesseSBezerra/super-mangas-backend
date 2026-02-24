package br.com.jdsb.supermangasbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MangaGenreDTO {

    private Long id;
    private Long mangaId;
    private String genre;
}
