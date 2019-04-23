package com.bookhotel.restapp.service;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookhotel.restapp.domain.Room;
import com.bookhotel.restapp.repository.RoomRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomServiceImplTest {

	
	@Autowired
	private RoomService roomService;
	
	@MockBean
	private RoomRepository roomRepository;

	@Test
	public void testFindAvailableRoomForDate() {
		Room room = new Room();
		roomRepository.save(room);
		Date arrival = new Date();
		Date departure = new Date();
		String filter = new String();
		List<Room> roomList = roomService.findAvailableRoomForDate(arrival, departure, filter);
		Assert.assertNotNull(roomList);
	}

	@Test
	public void testGetBookedRoom() {
		Room room = new Room();
		roomRepository.save(room);
		List<Room> roomList = roomService.findBookedRoom();
		Assert.assertNotNull(roomList);
	}
	@Test
	public void testAddNewDataRange() {
		Date arrival = new Date();
		Date departure = new Date();
		Room room = new Room();
		roomService.addNewDataRange(room, arrival, departure);
		Assert.assertNotNull(room.getBusyDateRange());
	}
}
