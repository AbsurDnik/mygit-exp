package com.bookhotel.restapp.service;

import java.util.Date;
import java.util.List;

import com.bookhotel.restapp.domain.Room;

public interface RoomService {


	List<Room> findAvailableRoomForDate(Date arrival, Date departure, String filter);

	List<Room> findBookedRoom();

	void addNewDataRange(Room room, Date arrival, Date departure);

	int calcTotalPrice(Room room);

}