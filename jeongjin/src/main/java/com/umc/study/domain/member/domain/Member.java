package com.umc.study.domain.member.domain;

import com.umc.study.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

@Getter
@Entity(name = "member")
@SQLDelete(sql = "UPDATE member SET deleted_at = NOW() where id = ?")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "bigint")
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(255)")
    private String name;

    @Column(name = "nickname", columnDefinition = "varchar(255)")
    private String nickname;

    @Column(name = "phone", columnDefinition = "varchar(11)")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", columnDefinition = "varchar(10)")
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "login_type", columnDefinition = "varchar(10)")
    private LoginType loginType;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "varchar(10)")
    private Gender gender;
}
