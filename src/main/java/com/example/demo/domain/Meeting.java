package com.example.demo.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Meeting {

	@NotBlank(message = "部屋番号を入力してください。")
	private String roomid;

	@NotBlank(message = "IDを入力してください。")
	private String id;

	@NotBlank(message = "利用日を入力してください。")
	private String day;

	@NotBlank(message = "利用者名を入力してください。")
	private String name;

	@Min(value = 1, message = "2以上の利用予定人数を入力してください。")
	@Max(value = 10, message = "8以下の利用予定人数を入力してください。")
	private Integer people;

	@Size(max = 50, message = "連絡先を入力してください。")
	private String phone;

	/// SET-GET///
	//部屋番号
	public String getRoomid() {
		return roomid;
	}
	//携帯番号
	public void setRoomid(String roomid) {
        this.roomid =roomid;
	}
	//お客様ID
	public String getId() {
		return id;
	}
    //お客様ID
	public void setId(String id) {
		this.id = id;
	}
	//利用希望日
	public String getDay() {
		return day;
	}
    //利用希望日
	public void setDay(String day) {
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
	public Integer getPeople() {
		return people;
	}
    //利用予定人数
	public void setPeople(Integer people) {
		this.people = people;
	}
	//携帯番号
	public String getPhone() {
		return phone;
	}
	//携帯番号
	public void setPhone(String phone) {
		this.phone = phone;
	}


}