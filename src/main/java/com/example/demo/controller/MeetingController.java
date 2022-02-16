package com.example.demo.controller;

import javax.validation.Valid;

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
@RequestMapping("/meetings")
public class MeetingController {

	@Autowired
	private MeetingService meetingService;

//////----------------画面遷移-------------------///////
	/**
	 * 一覧画面の表示
	 */
	@GetMapping
	public String top(Model model) {
		model.addAttribute("meetings", meetingService.findAll());
		return "meetings/top";
	}

	// * 新規作成画面の表示
	@GetMapping("new")
	public String newMeeting(@ModelAttribute("meeting")Meeting meeting,Model model) {
		return "meetings/new";
	}

//**詳細画面の表示

	@GetMapping("{roomid}")
	public String show(@PathVariable Long roomid, Model model) {
		model.addAttribute("meeting", meetingService.selectOne(roomid));
		return "meetings/show";
	}

//**編集画面の表示

	@GetMapping("{roomid}/edit")
	public String edit(@PathVariable Long roomid, @ModelAttribute("meeting") Meeting meeting, Model model) {
		model.addAttribute("meeting", meetingService.selectOne(roomid));
		return "meetings/edit";
	}

//////----------------CRUD処理-------------------///////

//** 新規作成画面の挿入処理

	 @PostMapping
	  public String create(@ModelAttribute("meeting") @Validated Meeting meeting, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	      return "new";
	    } else {
	      meetingService.save(meeting);
	      return "redirect:/meetings";
	    }
	  }

//**編集画面の更新処理

	@PutMapping("{roomid}")
	public String update(@PathVariable Long roomid, @ModelAttribute @Valid Meeting meeting,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "meetings/edit";
		}
		meeting.setRoomid(roomid);
		meetingService.update(meeting);
		return "redirect:/meetings";
	}

//**削除処理

	@DeleteMapping("{roomid}")
	public String delete(@PathVariable Long roomid) {
		meetingService.delete(roomid);
		return "redirect:/meetings";
	}
}