package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Meeting;
import com.example.demo.mapper.MeetingMapper;

@Service
public class MeetingService {

	@Autowired
	private MeetingMapper meetingMapper;

	//全件取得
	@Transactional
	public List<Meeting> findAll() {
		return meetingMapper.findAll();
	}

	//一件取得
	@Transactional
	public Meeting selectOne(String id) {
		return meetingMapper.selectOne(id);
	}

	//登録
	@Transactional
	public void insert(Meeting meeting) {
		meetingMapper.insert(meeting);
	}

	//更新
    public void update(Meeting meeting) {
    	meetingMapper.update(meeting);
    }
    
	@Transactional
	public void delete(Long id) {
		meetingMapper.delete(id);
	}


	}
