package com.example.demo.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Meeting {

	@NotBlank(message = "部屋番号を入力してください。")
	private int roomid;

	@NotBlank(message = "IDを入力してください。")
	private Long id;

	@NotBlank(message = "利用日を入力してください。")
	private Long day;

	@NotBlank(message = "利用者名を入力してください。")
	private String name;

	@Min(value = 1, message = "2以上の利用予定人数を入力してください。")
	@Max(value = 10, message = "8以下の利用予定人数を入力してください。")
	private int people;

	@Size(max = 50, message = "連絡先を入力してください。")
	private int phone;

	/// SET-GET///
	//部屋番号
	public int getRoomid() {
		return roomid;
	}
	//携帯番号
	public void setRoomid(int roomid) {
        this.roomid =roomid;
	}
	//お客様ID
	public Long getId() {
		return id;
	}
    //お客様ID
	public void setId(Long id) {
		this.id = id;
	}
	//利用希望日
	public Long getDay() {
		return day;
	}
    //利用希望日
	public void setDay(Long day) {
		this.day = day;
	}
	//利用者名
	public String getName() {
		return name;
	}
    //利用者名
	public void setName(String name) {
		this.name = name;
	}
    //利用予定人数
	public int getPeople() {
		return people;
	}
    //利用予定人数
	public void setPeople(int people) {
		this.people = people;
	}
	//携帯番号
	public int getPhone() {
		return phone;
	}
	//携帯番号
	public void setPhone(int phone) {
		this.phone = phone;
	}


}