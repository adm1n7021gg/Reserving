package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.Meeting;

@Mapper
public interface MeetingMapper {

  //全件取得
  public List<Meeting> findAll();

  //select1件
  public Meeting selectOne(Long roomid);
  
  //登録
  public int insert(Meeting meeting);
  
  //１件登録
  public int update(Meeting meeting);
  
  //削除処理
  public int delete(Long roomid);
}