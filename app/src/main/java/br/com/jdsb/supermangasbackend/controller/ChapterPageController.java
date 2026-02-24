package br.com.jdsb.supermangasbackend.controller;

import br.com.jdsb.supermangasbackend.dto.ChapterPageDTO;
import br.com.jdsb.supermangasbackend.service.ChapterPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pages")
@RequiredArgsConstructor
public class ChapterPageController {

    private final ChapterPageService chapterPageService;

    @GetMapping("/chapter/{chapterId}")
    public ResponseEntity<Page<ChapterPageDTO>> getPagesByChapterId(
            @PathVariable Long chapterId,
            @PageableDefault(size = 50, sort = "pageNumber") Pageable pageable) {
        Page<ChapterPageDTO> pages = chapterPageService.getPagesByChapterId(chapterId, pageable);
        return ResponseEntity.ok(pages);
    }

    @GetMapping("/chapter/{chapterId}/all")
    public ResponseEntity<List<ChapterPageDTO>> getAllPagesByChapterId(@PathVariable Long chapterId) {
        List<ChapterPageDTO> pages = chapterPageService.getAllPagesByChapterId(chapterId);
        return ResponseEntity.ok(pages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChapterPageDTO> getPageById(@PathVariable Long id) {
        ChapterPageDTO page = chapterPageService.getPageById(id);
        return ResponseEntity.ok(page);
    }
}
