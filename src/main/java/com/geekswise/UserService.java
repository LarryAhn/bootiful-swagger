package com.geekswise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserJpaRepository userJpaRepository;

    @Transactional
    public UserEntity save(UserEntity user) {
        return userJpaRepository.save(user);
    }

    @Transactional(readOnly = true)
    public UserEntity findOne(Long userId) {
        return userJpaRepository.findOne(userId);
    }

    @Transactional(readOnly = true)
    public List<UserEntity> findAll() {
        return userJpaRepository.findAll();
    }

}
