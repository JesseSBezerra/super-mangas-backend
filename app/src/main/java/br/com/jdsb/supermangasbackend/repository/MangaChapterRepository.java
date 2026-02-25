package br.com.jdsb.supermangasbackend.repository;

import br.com.jdsb.supermangasbackend.entity.MangaChapter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MangaChapterRepository extends JpaRepository<MangaChapter, Long> {

    Page<MangaChapter> findByMangaId(Long mangaId, Pageable pageable);

    List<MangaChapter> findByMangaIdOrderByIdDesc(Long mangaId);

    Long countByMangaId(Long mangaId);
}
