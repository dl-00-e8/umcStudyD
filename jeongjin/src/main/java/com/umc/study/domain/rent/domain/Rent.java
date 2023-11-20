package com.umc.study.domain.rent.domain;

import com.umc.study.domain.book.domain.Book;
import com.umc.study.domain.member.domain.Member;
import com.umc.study.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDateTime;

@Getter
@Entity(name = "rent")
@SQLDelete(sql = "UPDATE rent SET deleted_at = NOW() where id = ?")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Rent extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "bigint")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false, columnDefinition = "bigint")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false, columnDefinition = "bigint")
    private Book book;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column(name = "delay_count", columnDefinition = "int default 0")
    private Integer delayCount;
}