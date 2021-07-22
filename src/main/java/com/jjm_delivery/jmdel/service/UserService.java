package com.jjm_delivery.jmdel.service;

import com.jjm_delivery.jmdel.domain.User;
import com.jjm_delivery.jmdel.network.request.UserApiRequest;
import com.jjm_delivery.jmdel.network.response.UserApiResponse;
import com.jjm_delivery.jmdel.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserApiResponse createUser(UserApiRequest request){
        User user = User.builder()
                .account(request.getAccount())
                .password(request.getPassword())
                .email(request.getEmail())
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .createdAt(LocalDateTime.now())
                .build();

        User newUser = userRepository.save(user);
        return response(newUser);
    }

    public Optional<User> readUser(Long id){

        return userRepository.findById(id);
    }

    public Long updateUser(Long id, UserApiRequest request){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니. id="+id));

        User updateUser = User.builder()
                .id(id)
                .account(request.getAccount())
                .password(request.getPassword())
                .email(request.getEmail())
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .build();

        userRepository.save(updateUser);
        return id;
    }

    public void delete(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));

        userRepository.delete(user);
    }

    private UserApiResponse response(User user){
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())
                .email(user.getEmail())
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();

        return userApiResponse;
    }
}
