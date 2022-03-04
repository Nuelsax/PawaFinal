package com.pawaTaskOriginal.pawaAssignment.service;

import com.pawaTaskOriginal.pawaAssignment.dto.LoginDto;
import com.pawaTaskOriginal.pawaAssignment.models.User;

public interface UserService {
    User saveUser(User user);
    User loginUser(LoginDto loginDto);
}