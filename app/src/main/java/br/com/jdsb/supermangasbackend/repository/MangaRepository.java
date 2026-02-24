package br.com.jdsb.supermangasbackend.repository;

import br.com.jdsb.supermangasbackend.entity.Manga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Long> {

    Page<Manga> findAll(Pageable pageable);

    @Query("SELECT m FROM Manga m WHERE LOWER(m.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    Page<Manga> findByTitleContainingIgnoreCase(@Param("title") String title, Pageable pageable);

    Optional<Manga> findByMangaLink(String mangaLink);
}
