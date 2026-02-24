package br.com.jdsb.supermangasbackend.repository;

import br.com.jdsb.supermangasbackend.entity.MangaGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MangaGenreRepository extends JpaRepository<MangaGenre, Long> {

    List<MangaGenre> findByMangaId(Long mangaId);

    List<MangaGenre> findByGenre(String genre);
}
