package br.com.jdsb.supermangasbackend.service;

import br.com.jdsb.supermangasbackend.dto.MangaMetadataDTO;
import br.com.jdsb.supermangasbackend.entity.MangaMetadata;
import br.com.jdsb.supermangasbackend.repository.MangaMetadataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MangaMetadataService {

    private final MangaMetadataRepository mangaMetadataRepository;

    public List<MangaMetadataDTO> getMetadataByMangaId(Long mangaId) {
        return mangaMetadataRepository.findByMangaId(mangaId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public MangaMetadataDTO getMetadataByMangaIdAndKey(Long mangaId, String metaKey) {
        MangaMetadata metadata = mangaMetadataRepository.findByMangaIdAndMetaKey(mangaId, metaKey)
                .orElseThrow(() -> new RuntimeException("Metadata not found for manga: " + mangaId + " and key: " + metaKey));
        return convertToDTO(metadata);
    }

    private MangaMetadataDTO convertToDTO(MangaMetadata metadata) {
        MangaMetadataDTO dto = new MangaMetadataDTO();
        dto.setId(metadata.getId());
        dto.setMangaId(metadata.getMangaId());
        dto.setMetaKey(metadata.getMetaKey());
        dto.setMetaValue(metadata.getMetaValue());

        return dto;
    }
}
