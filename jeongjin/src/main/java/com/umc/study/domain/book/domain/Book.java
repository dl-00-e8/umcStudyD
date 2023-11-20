package com.umc.study.domain.book.domain;

import com.umc.study.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

@Getter
@Entity(name = "book")
@SQLDelete(sql = "UPDATE book SET deleted_at = NOW() where id = ?")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "bigint")
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(255)")
    private String name;

    @Column(name = "writer", columnDefinition = "varchar(255)")
    private String writer;

    @Column(name = "publisher", columnDefinition = "varchar(255)")
    private String publisher;

    @Column(name = "information", columnDefinition = "text")
    private String information;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", columnDefinition = "varchar(20)")
    private Category category;
}
