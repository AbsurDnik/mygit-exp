package com.bookhotel.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.bookhotel.restapp.domain.Room;

public interface RoomRepository extends CrudRepository<Room,Integer>{

	Iterable<Room> findByCategory(String category);
	
	Iterable<Room> findByCategoryAndIsBusy(String category,boolean isBusy);

	Iterable<Room> findByIsBusy(boolean isBusy);
}
