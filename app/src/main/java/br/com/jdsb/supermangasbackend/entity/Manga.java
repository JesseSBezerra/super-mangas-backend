package br.com.jdsb.supermangasbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "mangas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @Column(name = "image_path", length = 500)
    private String imagePath;

    @Column(name = "manga_link", length = 500)
    private String mangaLink;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "synopsis", columnDefinition = "TEXT")
    private String synopsis;

    @Column(name = "image_base64", columnDefinition = "TEXT")
    private String imageBase64;

    @OneToMany(mappedBy = "manga", fetch = FetchType.LAZY)
    private List<MangaChapter> chapters;

    @OneToMany(mappedBy = "manga", fetch = FetchType.LAZY)
    private List<MangaGenre> genres;

    @OneToMany(mappedBy = "manga", fetch = FetchType.LAZY)
    private List<MangaMetadata> metadata;
}
