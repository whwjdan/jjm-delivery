package com.jjm_delivery.jmdel.controller;

import com.jjm_delivery.jmdel.network.request.UserApiRequest;
import com.jjm_delivery.jmdel.network.response.UserApiResponse;
import com.jjm_delivery.jmdel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // /user/join으로부터 유저 요청을 받아 UserSaveRequestDto에 전달 후
    // userService로 전달
    // 회원가입시
    @PostMapping("/user/join")
    public void save(@RequestBody UserApiRequest userApiRequest){
        userService.createUser(userApiRequest);
    }

    @PutMapping("/user/update/{id}")
    public Long update(@PathVariable Long id, @RequestBody UserApiRequest userApiRequest){
        return userService.updateUser(id, userApiRequest);
    }

    @DeleteMapping("/user/delete/{id}")
    public Long delete(@PathVariable Long id){
        userService.delete(id);
        return id;
    }

}
