package br.com.jdsb.supermangasbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "manga_chapters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MangaChapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "manga_id")
    private Long mangaId;

    @Column(name = "chapter_number", length = 255)
    private String chapterNumber;

    @Column(name = "chapter_link", length = 500)
    private String chapterLink;

    @Column(name = "chapter_date", length = 255)
    private String chapterDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manga_id", insertable = false, updatable = false)
    private Manga manga;

    @OneToMany(mappedBy = "chapter", fetch = FetchType.LAZY)
    private List<ChapterPage> pages;
}
