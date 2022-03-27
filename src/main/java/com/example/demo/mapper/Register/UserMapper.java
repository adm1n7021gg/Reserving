package com.example.demo.mapper.Register;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.Login.User;

@Mapper
public interface UserMapper{
	
	@Select("select*from users where username = #{username}")
	Optional<User>findByUsername(String username);
	
	@Select("select*from users")
	List<User>findAll();
	
	@Insert("insert into users(username, password, authority) values (#{username},#{password},)")
	void insert(String username, String password);
}