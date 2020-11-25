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

import static org.junit.Assert.assertEquals;

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
	public void canFindAllWhiskiesByYear() {
		List<Whisky> found = whiskyRepository.findWhiskysByYear(2018);
		assertEquals(6, found.size());
	}

	@Test
	public void canFindAllDistilleriesByRegion(){
		List<Distillery> found = distilleryRepository.findAllDistilleriesByRegion("Speyside");
		assertEquals(3, found.size());
	}
//
	@Test
	public void canFindWhiskyByYearFromDistillery(){
		List<Whisky> found = whiskyRepository.findWhiskysByDistilleryNameAndAge("Highland Park", 12);
		assertEquals(1, found.size());
	}
////
	@Test
	public void canFindWhiskysByRegion(){
		List <Whisky> found = whiskyRepository.findWhiskysByDistilleryRegion("Speyside");
		assertEquals(3, found.size());
	}

	@Test
	public void canFindDistilleryByWhiskyAge(){
		List<Distillery> found = distilleryRepository.findDistilleriesByWhiskiesAge(12);
		assertEquals(6,found.size());
	}


}
