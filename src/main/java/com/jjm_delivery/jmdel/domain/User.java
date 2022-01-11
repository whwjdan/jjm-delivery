package com.jjm_delivery.jmdel.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/*
@Builder 어노테이션은 Builder 클래스를 자동으로 추가해준다.
setter 메서드 사용 시 객체의 일관성(consistency)가 보장될 수 없고,
immutable한 객체를 생성할 수 없다.

또한 build() 메서드를 통해 생성자 호출시 체이닝 패턴을 통해
각 객체의 의미를 파악할 수 있다.

ex) 빌더 패턴으로 객체 생성

    User user = User.builder()
            .id(1L)
            .account("user_test")
            .password("1234")
            .email("jjm@naver.com")
            .name("테스트")
            .phoneNumber("010-1111-1111")
            .build();

 */

@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String account;

    @NotEmpty
    private String password;

    @NotEmpty
    private String email;

    @NotEmpty
    private String name;

    @NotEmpty
    private String phoneNumber;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public User(Long id, String account, String password, String email
            , String name, String phoneNumber, LocalDateTime createdAt){
        this.id = id;
        this.account = account;
        this.password = password;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
    }

    public User(String account) {
        this.account = account;
    }
}
