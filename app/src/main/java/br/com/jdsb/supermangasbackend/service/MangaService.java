package br.com.jdsb.supermangasbackend.service;

import br.com.jdsb.supermangasbackend.dto.MangaDTO;
import br.com.jdsb.supermangasbackend.entity.Manga;
import br.com.jdsb.supermangasbackend.entity.MangaGenre;
import br.com.jdsb.supermangasbackend.repository.MangaChapterRepository;
import br.com.jdsb.supermangasbackend.repository.MangaGenreRepository;
import br.com.jdsb.supermangasbackend.repository.MangaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MangaService {

    private final MangaRepository mangaRepository;
    private final MangaGenreRepository mangaGenreRepository;
    private final MangaChapterRepository mangaChapterRepository;

    public Page<MangaDTO> getAllMangas(Pageable pageable) {
        return mangaRepository.findAll(pageable).map(this::convertToDTO);
    }

    public MangaDTO getMangaById(Long id) {
        Manga manga = mangaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manga not found with id: " + id));
        return convertToDTO(manga);
    }

    public Page<MangaDTO> searchMangasByTitle(String title, Pageable pageable) {
        return mangaRepository.findByTitleContainingIgnoreCase(title, pageable)
                .map(this::convertToDTO);
    }

    private MangaDTO convertToDTO(Manga manga) {
        List<String> genres = mangaGenreRepository.findByMangaId(manga.getId())
                .stream()
                .map(MangaGenre::getGenre)
                .collect(Collectors.toList());

        Long totalChapters = mangaChapterRepository.countByMangaId(manga.getId());

        MangaDTO dto = new MangaDTO();
        dto.setId(manga.getId());
        dto.setTitle(manga.getTitle());
        dto.setImageUrl(manga.getImageUrl());
        dto.setImagePath(manga.getImagePath());
        dto.setMangaLink(manga.getMangaLink());
        dto.setCreatedAt(manga.getCreatedAt());
        dto.setUpdatedAt(manga.getUpdatedAt());
        dto.setSynopsis(manga.getSynopsis());
        dto.setImageBase64(manga.getImageBase64());
        dto.setGenres(genres);
        dto.setTotalChapters(totalChapters);

        return dto;
    }
}
