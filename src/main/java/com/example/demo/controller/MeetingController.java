package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Meeting;
import com.example.demo.service.MeetingService;

@Controller
@RequestMapping("/room")
public class MeetingController {

	@Autowired
	private MeetingService meetingService;

	// 一覧画面表示
	@GetMapping
	public String top(Model model) {
		model.addAttribute("meetings", meetingService.findAll());
		return "meetings/top";
	}

	// 新規登録画面表示
	@GetMapping("meetings/new")
	public String newMeeting(@ModelAttribute("meeting") Meeting meeting, Model model) {
		return "meetings/new";
	}

	/// CRUD処理///

	/// --①詳細表示--///
	@GetMapping("{roomid}")
	public String show(@PathVariable Long roomid, Model model) {
		model.addAttribute("meeting", meetingService.selectOne(roomid));
		return "meetings/show";
	}

	/// --②-1編集（更新）--///
	@GetMapping("{roomid}/edit")
	public String edit(@PathVariable Long roomid, @ModelAttribute("meeting") Meeting meeting, Model model) {
		model.addAttribute("meeting", meetingService.selectOne(roomid));
		return "meetings/edit";
	}
	/// --②-2編集（更新）--///
	@PutMapping("{roomid}")
	public String update(@PathVariable Long roomid, @ModelAttribute("meeting") @Validated Meeting meeting,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("meeting", meeting);
			return "meetings/edit";
		} else {
			meeting.setRoomid(roomid);
			meetingService.update(meeting);
			return "redirect:/items";
		}
	}

	/// --③登録--///
	@PostMapping
	public String create(@ModelAttribute("meeting") @Validated Meeting meeting, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "meetings/new";
		} else {
			meetingService.insert(meeting);
			return "redirect:/meetings";
		}
	}
    //--④削除処理--///
	@DeleteMapping("{roomid}")
	public String delete(@PathVariable Long roomid) {
		meetingService.delete(roomid);
		return "redirect:/meetingss";
	}
}