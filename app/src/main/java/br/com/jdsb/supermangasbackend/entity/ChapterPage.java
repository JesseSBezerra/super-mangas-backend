package br.com.jdsb.supermangasbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "chapter_pages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChapterPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chapter_id")
    private Long chapterId;

    @Column(name = "page_number")
    private Integer pageNumber;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @Column(name = "image_path", length = 500)
    private String imagePath;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "image_base64", columnDefinition = "TEXT")
    private String imageBase64;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapter_id", insertable = false, updatable = false)
    private MangaChapter chapter;
}
