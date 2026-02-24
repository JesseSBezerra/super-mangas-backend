package br.com.jdsb.supermangasbackend.service;

import br.com.jdsb.supermangasbackend.dto.MangaGenreDTO;
import br.com.jdsb.supermangasbackend.entity.MangaGenre;
import br.com.jdsb.supermangasbackend.repository.MangaGenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MangaGenreService {

    private final MangaGenreRepository mangaGenreRepository;

    public List<MangaGenreDTO> getGenresByMangaId(Long mangaId) {
        return mangaGenreRepository.findByMangaId(mangaId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<MangaGenreDTO> getMangasByGenre(String genre) {
        return mangaGenreRepository.findByGenre(genre)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private MangaGenreDTO convertToDTO(MangaGenre genre) {
        MangaGenreDTO dto = new MangaGenreDTO();
        dto.setId(genre.getId());
        dto.setMangaId(genre.getMangaId());
        dto.setGenre(genre.getGenre());

        return dto;
    }
}
