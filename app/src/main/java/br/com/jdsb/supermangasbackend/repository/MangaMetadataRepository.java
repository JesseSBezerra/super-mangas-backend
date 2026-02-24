package br.com.jdsb.supermangasbackend.repository;

import br.com.jdsb.supermangasbackend.entity.MangaMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MangaMetadataRepository extends JpaRepository<MangaMetadata, Long> {

    List<MangaMetadata> findByMangaId(Long mangaId);

    Optional<MangaMetadata> findByMangaIdAndMetaKey(Long mangaId, String metaKey);
}
