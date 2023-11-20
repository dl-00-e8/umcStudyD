package com.umc.study.domain.book.domain;

import com.umc.study.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

@Getter
@Entity(name = "book_and_hashtag")
@SQLDelete(sql = "UPDATE book_and_hashtag SET deleted_at = NOW() where id = ?")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookAndHashtag extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "bigint")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false, columnDefinition = "bigint")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "hashtag_id", nullable = false, columnDefinition = "bigint")
    private Hashtag hashtag;
}
