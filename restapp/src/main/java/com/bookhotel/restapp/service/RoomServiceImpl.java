package com.bookhotel.restapp.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookhotel.restapp.domain.Room;
import com.bookhotel.restapp.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomRepository roomRepository;
	
	private final int secondsInDay = 86400000;
	
	@Override
	public List<Room> findAvailableRoomForDate(Date arrival, Date departure,String filter) {
		Iterable<Room> roomList = roomRepository.findAll();
		List<Room> resultRoomList = new ArrayList<Room>();
		for(Room room : roomList) {
			Map<Date,Date> rangeMap = room.getBusyDataRange();
			if(
					!isDateIntersect(rangeMap,arrival,departure) 
					&& (room.getCategory().equals(filter) || filter.isEmpty())
					&& !room.isBusy()
					) {
				resultRoomList.add(room);
			}
		}
		
		return resultRoomList;
	}
		
	@Override
	public List<Room> findBookedRoom() {
		List<Room> resultList = new ArrayList<Room>();
		List<Room> tempList = (List<Room>) roomRepository.findAll();
		for(Room room : tempList) {
			if(!room.getBusyDataRange().isEmpty() && !room.isBusy()) {
				resultList.add(room);
			}
		}
		return resultList;
	}
	
	private boolean isDateIntersect(Map<Date, Date> temp, Date adjustedArrival, Date adjustedDeparture) {
		boolean result = false;
		Set<Date> arrivalSet = temp.keySet();
		for(Date arrival : arrivalSet) {
			
			
			if(adjustedArrival.after(arrival)) {
				Date departure = temp.get(arrival);
				if(adjustedArrival.after(departure)) {
					result = false;
				}
				if(adjustedArrival.before(departure)) {
					result = true;
				}
			}else if(adjustedArrival.before(arrival)) {
				if(adjustedDeparture.after(arrival)) {
					result = true;
				}
				if(adjustedDeparture.before(arrival)) {
					result = false;
				}
			}
			
			if(result) {
				break;
			}
		}
		return result;
		
	}

	@Override
	public void addNewDataRange(Room room, Date arrival, Date departure) {
		Map<Date,Date> temp = room.getBusyDataRange();
		temp.put(arrival, departure);
		room.setBusyDataRange(temp);
		roomRepository.save(room);
	}

	@Override
	public int calcTotalPrice(Room room) {
		Map<Date, Date> temp = room.getBusyDataRange();
		Set<Date> arrivalSet = temp.keySet();
		int totalPrice = 0;
		int amountDay = 0;
		for(Date arrival : arrivalSet) {
			Date departure = temp.get(arrival);
			amountDay = (int)(departure.getTime() - arrival.getTime())/secondsInDay;
			totalPrice += (amountDay)*room.getPrice();
			totalPrice += (amountDay)*room.getPriceBreakfast();
			totalPrice += (amountDay)*room.getPriceCleaning();
		}
				
		return totalPrice;
	}
}
