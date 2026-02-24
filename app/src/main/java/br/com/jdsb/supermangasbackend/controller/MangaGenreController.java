package br.com.jdsb.supermangasbackend.controller;

import br.com.jdsb.supermangasbackend.dto.MangaGenreDTO;
import br.com.jdsb.supermangasbackend.service.MangaGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
@RequiredArgsConstructor
public class MangaGenreController {

    private final MangaGenreService mangaGenreService;

    @GetMapping("/manga/{mangaId}")
    public ResponseEntity<List<MangaGenreDTO>> getGenresByMangaId(@PathVariable Long mangaId) {
        List<MangaGenreDTO> genres = mangaGenreService.getGenresByMangaId(mangaId);
        return ResponseEntity.ok(genres);
    }

    @GetMapping("/search")
    public ResponseEntity<List<MangaGenreDTO>> getMangasByGenre(@RequestParam String genre) {
        List<MangaGenreDTO> mangas = mangaGenreService.getMangasByGenre(genre);
        return ResponseEntity.ok(mangas);
    }
}
