package br.com.jdsb.supermangasbackend.repository;

import br.com.jdsb.supermangasbackend.entity.ChapterPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChapterPageRepository extends JpaRepository<ChapterPage, Long> {

    Page<ChapterPage> findByChapterIdOrderByPageNumber(Long chapterId, Pageable pageable);

    List<ChapterPage> findByChapterIdOrderByPageNumber(Long chapterId);

    Long countByChapterId(Long chapterId);
}
