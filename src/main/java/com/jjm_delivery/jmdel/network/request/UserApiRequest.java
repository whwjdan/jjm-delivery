package com.jjm_delivery.jmdel.network.request;

import com.jjm_delivery.jmdel.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserApiRequest {

    // 회원가입 기능, 회원가입 화면에서 사용자 정보 입력 후
    // 요청을 받으면 Dto에서 서비스단으로 전달해주며 처리
    private Long id;
    private String account;
    private String password;
    private String email;
    private String name;
    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-mm-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @DateTimeFormat(pattern = "yyyy-mm-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;

    // 회원가입시 사용
    @Builder
    public UserApiRequest(Long id, String account, String password, String email
            , String name, String phoneNumber, LocalDateTime createdAt
            , LocalDateTime updatedAt){
        this.id = id;
        this.account = account;
        this.password = password;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.createdAt = LocalDateTime.now();
    }

    // 회원정보 수정시 사용 createdAt 변수 받지않음
    @Builder
    public UserApiRequest(Long id, String account, String password, String email
            , String name, String phoneNumber, LocalDateTime updatedAt){
        this.id = id;
        this.account = account;
        this.password = password;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.updatedAt = LocalDateTime.now();
    }
}
