package com.bookhotel.restapp.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bookhotel.restapp.domain.Room;

public class RoomServiceTest{
	@Autowired
	private RoomService roomService;


	@Test
	public void testFindAvailableRoomForDate() {
		Date arrival = new Date();
		Date departure = new Date();
		String filter = new String();
		List<Room> roomList = roomService.findAvailableRoomForDate(arrival, departure, filter);
		//Assert.
	}

	@Test
	public void testGetBookedRoom() {
		//roomService.getBookedRoom();
	}

}
