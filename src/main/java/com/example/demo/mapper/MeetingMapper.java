package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Meeting;

@Mapper
public interface MeetingMapper {
	List<Meeting> findAll();
	
	 Meeting selectOne(Long roomid);
	
	void insert(Meeting meeting);
	
	void update(Meeting meeting);
	
	void delete(Long roomid);
}
