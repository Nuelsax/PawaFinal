package com.pawaTaskOriginal.pawaAssignment.controller;

import com.pawaTaskOriginal.pawaAssignment.dto.LoginDto;
import com.pawaTaskOriginal.pawaAssignment.dto.ResponseDto;
import com.pawaTaskOriginal.pawaAssignment.models.User;
import com.pawaTaskOriginal.pawaAssignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("pawa/api/user")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User addUser(@RequestBody User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return userService.saveUser(user);

    }

    @PostMapping("/login")
    public ResponseDto login(@RequestBody LoginDto loginDto, HttpServletRequest request) {
        HttpSession session = request.getSession();
        ResponseDto responseDto = new ResponseDto();
        System.out.println("this is login dto" + loginDto.getEmail() + loginDto.getPassword());
        User person = userService.loginUser(loginDto);
        System.out.println("this is the user" + person);
        if(person == null) {
            responseDto.setUserId(0l);
            return  responseDto;
        } else {
            session.setAttribute("user", person);
            responseDto.setUserId(person.getId());
            return responseDto;
        }
    }

}
