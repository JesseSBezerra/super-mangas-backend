package br.com.jdsb.supermangasbackend.service;

import br.com.jdsb.supermangasbackend.dto.MangaChapterDTO;
import br.com.jdsb.supermangasbackend.entity.MangaChapter;
import br.com.jdsb.supermangasbackend.repository.ChapterPageRepository;
import br.com.jdsb.supermangasbackend.repository.MangaChapterRepository;
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
public class MangaChapterService {

    private final MangaChapterRepository mangaChapterRepository;
    private final ChapterPageRepository chapterPageRepository;

    public Page<MangaChapterDTO> getChaptersByMangaId(Long mangaId, Pageable pageable) {
        return mangaChapterRepository.findByMangaId(mangaId, pageable)
                .map(this::convertToDTO);
    }

    public List<MangaChapterDTO> getAllChaptersByMangaId(Long mangaId) {
        return mangaChapterRepository.findByMangaIdOrderByIdDesc(mangaId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public MangaChapterDTO getChapterById(Long id) {
        MangaChapter chapter = mangaChapterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chapter not found with id: " + id));
        return convertToDTO(chapter);
    }

    private MangaChapterDTO convertToDTO(MangaChapter chapter) {
        Long totalPages = chapterPageRepository.countByChapterId(chapter.getId());

        MangaChapterDTO dto = new MangaChapterDTO();
        dto.setId(chapter.getId());
        dto.setMangaId(chapter.getMangaId());
        dto.setChapterNumber(chapter.getChapterNumber());
        dto.setChapterLink(chapter.getChapterLink());
        dto.setChapterDate(chapter.getChapterDate());
        dto.setCreatedAt(chapter.getCreatedAt());
        dto.setTotalPages(totalPages);

        return dto;
    }
}
