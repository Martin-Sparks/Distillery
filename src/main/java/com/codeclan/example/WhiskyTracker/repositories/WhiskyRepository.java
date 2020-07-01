package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findWhiskysByYear(int year);

    List<Whisky> findWhiskysByDistilleryAndAge(Distillery distillery, int age);

//    List<Whisky> findWhiskyByRegion(List<Distillery> distilleries);

}

