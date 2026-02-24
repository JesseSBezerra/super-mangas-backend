package br.com.jdsb.supermangasbackend.service;

import br.com.jdsb.supermangasbackend.dto.ChapterPageDTO;
import br.com.jdsb.supermangasbackend.entity.ChapterPage;
import br.com.jdsb.supermangasbackend.repository.ChapterPageRepository;
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
public class ChapterPageService {

    private final ChapterPageRepository chapterPageRepository;

    public Page<ChapterPageDTO> getPagesByChapterId(Long chapterId, Pageable pageable) {
        return chapterPageRepository.findByChapterIdOrderByPageNumber(chapterId, pageable)
                .map(this::convertToDTO);
    }

    public List<ChapterPageDTO> getAllPagesByChapterId(Long chapterId) {
        return chapterPageRepository.findByChapterIdOrderByPageNumber(chapterId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ChapterPageDTO getPageById(Long id) {
        ChapterPage page = chapterPageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Page not found with id: " + id));
        return convertToDTO(page);
    }

    private ChapterPageDTO convertToDTO(ChapterPage page) {
        ChapterPageDTO dto = new ChapterPageDTO();
        dto.setId(page.getId());
        dto.setChapterId(page.getChapterId());
        dto.setPageNumber(page.getPageNumber());
        dto.setImageUrl(page.getImageUrl());
        dto.setImagePath(page.getImagePath());
        dto.setCreatedAt(page.getCreatedAt());
        dto.setImageBase64(page.getImageBase64());

        return dto;
    }
}
