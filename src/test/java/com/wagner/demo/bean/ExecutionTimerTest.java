package com.wagner.demo.bean;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wagner.demo.service.SeekerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:root-context.xml")
public class ExecutionTimerTest {
	@Autowired
	SeekerService seekerServiceImpl;
	@Autowired
	SeekerData seekerData;
	@Autowired
	SeekerConfig seekerConfig;

	@Before
	public void insertData() {
		seekerConfig.setArrayASize(10000);
		seekerConfig.setArrayBSize(10000);
		seekerServiceImpl.populateData(seekerData, seekerConfig);
	}

	@Test
	public void executionTimeShouldNotBeNull() {
		seekerServiceImpl.findIntersection(new HashSet<Integer>(seekerData.getArrayA()), seekerData.getArrayB(),
				seekerData);
		assertNotNull(seekerData.getExecutionTime());
	}

	@Test
	public void executionTimeShouldNotBeNullNaiveMethod() {
		seekerServiceImpl.findIntersectionNaiveMethod(seekerData);
		assertNotNull(seekerData.getExecutionTimeNaiveMethod());
	}
}