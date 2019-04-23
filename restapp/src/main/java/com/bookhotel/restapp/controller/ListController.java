package com.bookhotel.restapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookhotel.restapp.domain.Room;
import com.bookhotel.restapp.repository.RoomRepository;
import com.bookhotel.restapp.service.RoomService;

@RestController
public class ListController {
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/booklist")
	public List<Room> getBookListPage(Model model) {
		return (List<Room>)roomRepository.findAll();
	}
	
	@GetMapping("/mybooklist")
	public List<Room> getMyBookingPage(Model model) {
		return roomService.findBookedRoom();
	}
	
	@PostMapping("/adding-room")
	public String addBook(
			@RequestParam Integer number,
			@RequestParam String category,			
			@RequestParam Integer price,
			@RequestParam(required = false,defaultValue = "false") boolean isBusy 
			) {
		
		Room tempRoom = new Room(number,category,price,isBusy);
		roomRepository.save(tempRoom);
		return "<a href = '/adding-room'>Back</a>";
	}
}
