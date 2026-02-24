package br.com.jdsb.supermangasbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MangaMetadataDTO {

    private Long id;
    private Long mangaId;
    private String metaKey;
    private String metaValue;
}
