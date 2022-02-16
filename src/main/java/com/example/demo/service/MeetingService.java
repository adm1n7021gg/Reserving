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
	public Meeting selectOne(Long roomid) {
		return meetingMapper.selectOne(roomid);
	}

	//登録
	@Transactional
	public void insert(Meeting meeting) {
		meetingMapper.insert(meeting);
	}

	//更新
	@Transactional
	public int update(Meeting meeting) {
		 return meetingMapper.update(meeting);
	}

	//削除
	@Transactional
	public void delete(Long roomid) {
		meetingMapper.delete(roomid);
	}

	public void save(Meeting meeting) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}