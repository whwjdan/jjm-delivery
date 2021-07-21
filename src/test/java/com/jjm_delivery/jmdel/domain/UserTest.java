package com.jjm_delivery.jmdel.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class UserTest {
    @Test
    void creation(){
        User user = User.builder()
                .account("user_test")
                .password("1234")
                .email("jjm@naver.com")
                .name("테스트")
                .phoneNumber("010-1111-1111")
                .build();

        assertThat(user.getAccount()).isEqualTo("user_test");
        assertThat(user.getPassword()).isEqualTo("1234");
        assertThat(user.getEmail()).isEqualTo("jjm@naver.com");
        assertThat(user.getName()).isEqualTo("테스트");
        assertThat(user.getPhoneNumber()).isEqualTo("010-1111-1111");
    }
}