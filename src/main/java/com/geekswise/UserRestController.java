package com.geekswise;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
@Api(description = "User API")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/users")
    @ApiOperation(value = "유저 생성",
            notes = "유저를 저장 할 수 있다 <br>" +
                    "저장된 유저 데이터를 반환",
            tags = {"User API"})
    public ResponseEntity<?> saveUser(@RequestBody UserEntity.save userSaveDto) {
        UserEntity user = userService.save(modelMapper.map(userSaveDto, UserEntity.class));
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}")
    @ApiOperation(value = "유저 조회",
            notes = "유저를 조회 할 수 있다",
            tags = {"User API"})
    public ResponseEntity<?> findUser(@PathVariable(name = "userId") Long userId) {
        return new ResponseEntity<>(userService.findOne(userId), HttpStatus.OK);
    }

    @GetMapping("/users")
    @ApiOperation(value = "유저 리스트 조회",
            notes = "유저 리스트를 조회 할 수 있다",
            tags = {"User API"})
    public ResponseEntity<?> findUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

}
