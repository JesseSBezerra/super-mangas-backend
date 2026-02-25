package br.com.jdsb.supermangasbackend.controller;

import br.com.jdsb.supermangasbackend.dto.MangaChapterDTO;
import br.com.jdsb.supermangasbackend.service.MangaChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chapters")
@RequiredArgsConstructor
public class MangaChapterController {

    private final MangaChapterService mangaChapterService;

    @GetMapping("/manga/{mangaId}")
    public ResponseEntity<Page<MangaChapterDTO>> getChaptersByMangaId(
            @PathVariable Long mangaId,
            @PageableDefault(size = 20, sort = "id", direction = org.springframework.data.domain.Sort.Direction.DESC) Pageable pageable) {
        Page<MangaChapterDTO> chapters = mangaChapterService.getChaptersByMangaId(mangaId, pageable);
        return ResponseEntity.ok(chapters);
    }

    @GetMapping("/manga/{mangaId}/all")
    public ResponseEntity<List<MangaChapterDTO>> getAllChaptersByMangaId(@PathVariable Long mangaId) {
        List<MangaChapterDTO> chapters = mangaChapterService.getAllChaptersByMangaId(mangaId);
        return ResponseEntity.ok(chapters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MangaChapterDTO> getChapterById(@PathVariable Long id) {
        MangaChapterDTO chapter = mangaChapterService.getChapterById(id);
        return ResponseEntity.ok(chapter);
    }
}
