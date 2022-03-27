package com.example.demo.service.Login;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Login.User;
import com.example.demo.mapper.Register.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService{
	
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;
	
	public List<User>findAll(){
		return userMapper.findAll();
	}
	
	public void create(String username, String password) {
		var encodedPassword = passwordEncoder.encode(password);
		userMapper.insert(username, encodedPassword);
	}
}