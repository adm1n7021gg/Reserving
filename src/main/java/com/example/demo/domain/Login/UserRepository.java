package com.example.demo.domain.Login;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.userdetails.User;


@Mapper
public interface UserRepository{
	
	@Select("select*from users where username = #{username}")
	Optional<User>findByUsername(String username);
}