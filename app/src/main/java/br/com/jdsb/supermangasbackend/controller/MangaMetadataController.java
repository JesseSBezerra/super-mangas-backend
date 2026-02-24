package br.com.jdsb.supermangasbackend.controller;

import br.com.jdsb.supermangasbackend.dto.MangaMetadataDTO;
import br.com.jdsb.supermangasbackend.service.MangaMetadataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metadata")
@RequiredArgsConstructor
public class MangaMetadataController {

    private final MangaMetadataService mangaMetadataService;

    @GetMapping("/manga/{mangaId}")
    public ResponseEntity<List<MangaMetadataDTO>> getMetadataByMangaId(@PathVariable Long mangaId) {
        List<MangaMetadataDTO> metadata = mangaMetadataService.getMetadataByMangaId(mangaId);
        return ResponseEntity.ok(metadata);
    }

    @GetMapping("/manga/{mangaId}/key/{metaKey}")
    public ResponseEntity<MangaMetadataDTO> getMetadataByMangaIdAndKey(
            @PathVariable Long mangaId,
            @PathVariable String metaKey) {
        MangaMetadataDTO metadata = mangaMetadataService.getMetadataByMangaIdAndKey(mangaId, metaKey);
        return ResponseEntity.ok(metadata);
    }
}
