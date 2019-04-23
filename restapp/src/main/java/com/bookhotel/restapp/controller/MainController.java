package com.bookhotel.restapp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookhotel.restapp.domain.Room;
import com.bookhotel.restapp.service.RoomService;

@Controller
public class MainController {
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/")
	public String getMainPage(Model model) {
		List<Room> mybooking = roomService.findBookedRoom();
		int totalPrice = 0;
		for(Room room : mybooking) {
			totalPrice += roomService.calcTotalPrice(room);
		}

		model.addAttribute("totalPrice",totalPrice);
		return "main";
	}
	
	@GetMapping("/booking-the-room")
	public String getBookingPage(
			@RequestParam(required = false,defaultValue = "") String filter,
			@RequestParam(required = false,defaultValue = "") String arrivalDate,
			@RequestParam(required = false,defaultValue = "") String departureDate,
			Model model) throws ParseException {
		List<Room> result = new ArrayList<Room>();
		
		if(!arrivalDate.isEmpty() && !departureDate.isEmpty()) {
			Date arrival = new SimpleDateFormat("yyyy-MM-dd").parse(arrivalDate);
			Date departure = new SimpleDateFormat("yyyy-MM-dd").parse(departureDate);
			
			model.addAttribute("arrivalDate",arrivalDate);
			model.addAttribute("departureDate",departureDate);
			
			
			result = roomService.findAvailableRoomForDate(arrival,departure,filter);
			model.addAttribute("availableRooms",result);
		}
		
		model.addAttribute("filter",filter);
		return "bookingRoom";
	}
	@PostMapping("/booking-the-room/{room_id}")
	public String bookRoom(
			@RequestParam String arrivalDate,
			@RequestParam String departureDate,
			@PathVariable(value = "room_id") Room room,
			Model model) throws ParseException {
		
		Date arrival = new SimpleDateFormat("yyyy-MM-dd").parse(arrivalDate);
		Date departure = new SimpleDateFormat("yyyy-MM-dd").parse(departureDate);
		
		roomService.addNewDataRange(room,arrival,departure);
		
		return "redirect:/booking-the-room";
	}
	
	@GetMapping("/adding-room")
	public String addRoom() {
		return "addroom";
	}
}
