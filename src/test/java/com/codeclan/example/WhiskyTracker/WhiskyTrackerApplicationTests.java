package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskysByYear(){
		List<Whisky> foundWhiskys = whiskyRepository.findWhiskysByYear(2018);
		assertTrue(foundWhiskys.size() > 0);
	}

	@Test
	public void canFindDistilleriesByRegion(){
		List<Distillery> foundDistilleries = distilleryRepository.findDistilleriesByRegion("Speyside");
		assertTrue(foundDistilleries.size() > 0);
	}

	@Test
	public void canFindDistilleriesByName(){
		List<Distillery> foundDistilleries = distilleryRepository.findDistilleriesByName("Glendronach");
		assertTrue(foundDistilleries.size() > 0);
	}

	@Test
	public void canFindWhiskysByDistilleryAndAge(){
		Distillery foundDistillery = distilleryRepository.getOne(1L);
		List<Whisky> foundWhiskys = whiskyRepository.findWhiskysByDistilleryAndAge(foundDistillery, 12);
		assertTrue(foundWhiskys.size() > 0);
	}

//	@Test
//	public void canFindWhiskyByRegion(){
//		List<Whisky> foundWhiskys = whiskyRepository.findWhiskyByRegion(distilleryRepository.findAll().)
//	}

}
