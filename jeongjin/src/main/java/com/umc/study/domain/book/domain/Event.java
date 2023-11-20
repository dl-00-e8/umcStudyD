package com.umc.study.domain.book.domain;

import com.umc.study.domain.member.domain.Member;
import com.umc.study.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

@Getter
@Entity(name = "event")
@SQLDelete(sql = "UPDATE event SET deleted_at = NOW() where id = ?")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Event extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "bigint")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false, updatable = false, columnDefinition = "bigint")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false, updatable = false, columnDefinition = "bigint")
    private Book book;
}
