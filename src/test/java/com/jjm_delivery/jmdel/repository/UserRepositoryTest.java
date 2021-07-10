package com.jjm_delivery.jmdel.repository;

import com.jjm_delivery.jmdel.JjmDeliveryApplicationTests;
import com.jjm_delivery.jmdel.domain.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/*

Repository 테스트는 데이터베이스에 CRUD가 제대로 이루어 지는지
테스트 하기 위함이며, 실제 서비스 로직에선 컨트롤러를 통해 JSON 객체가 들어오므로
Controller 테스트와 햇갈리지 않아야 한다.

 */

public class UserRepositoryTest extends JjmDeliveryApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void 회원가입_불러오기(){

        User user = User.builder()
                .account("user_test")
                .password("1234")
                .email("jjm@naver.com")
                .name("테스트")
                .phoneNumber("010-1111-1111")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        //given
        User newUser = userRepository.save(user);
        assertThat(newUser).isNotNull();

        //when
        Optional<User> readUser = userRepository.findByAccount("user_test");

        //then
        readUser.ifPresent(selectUser -> {
            assertThat(selectUser.getAccount()).isEqualTo("user_test");
        });
    }

}