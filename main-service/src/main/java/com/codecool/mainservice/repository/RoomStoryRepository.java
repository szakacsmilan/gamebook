package com.codecool.mainservice.repository;

import com.codecool.mainservice.model.RoomStory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomStoryRepository extends JpaRepository<RoomStory, Long> {
}
