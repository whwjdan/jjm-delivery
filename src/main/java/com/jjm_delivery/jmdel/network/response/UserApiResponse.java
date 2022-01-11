package com.jjm_delivery.jmdel.network.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserApiResponse {

    // 회원가입 기능, 회원가입 화면에서 사용자 정보 입력 후
    // 요청을 받으면 Dto에서 서비스단으로 전달해주며 처리
    private Long id;
    private String account;
    private String password;
    private String email;
    private String name;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
