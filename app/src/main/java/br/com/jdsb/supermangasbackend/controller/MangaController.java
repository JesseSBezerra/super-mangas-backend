package br.com.jdsb.supermangasbackend.controller;

import br.com.jdsb.supermangasbackend.dto.MangaDTO;
import br.com.jdsb.supermangasbackend.service.MangaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mangas")
@RequiredArgsConstructor
public class MangaController {

    private final MangaService mangaService;

    @GetMapping
    public ResponseEntity<Page<MangaDTO>> getAllMangas(
            @PageableDefault(size = 20, sort = "id") Pageable pageable) {
        Page<MangaDTO> mangas = mangaService.getAllMangas(pageable);
        return ResponseEntity.ok(mangas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MangaDTO> getMangaById(@PathVariable Long id) {
        MangaDTO manga = mangaService.getMangaById(id);
        return ResponseEntity.ok(manga);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<MangaDTO>> searchMangas(
            @RequestParam String title,
            @PageableDefault(size = 20, sort = "id") Pageable pageable) {
        Page<MangaDTO> mangas = mangaService.searchMangasByTitle(title, pageable);
        return ResponseEntity.ok(mangas);
    }
}
