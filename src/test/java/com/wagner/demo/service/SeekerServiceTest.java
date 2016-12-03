package com.wagner.demo.service;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wagner.demo.bean.SeekerConfig;
import com.wagner.demo.bean.SeekerData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:root-context.xml")
public class SeekerServiceTest {
	@Autowired
	SeekerService seekerServiceImpl;
	@Autowired
	SeekerData seekerData;
	@Autowired
	SeekerConfig seekerConfig;

	@Before
	public void insertData() {
		seekerConfig.setArrayASize(10000);
		seekerConfig.setArrayBSize(15000);
		seekerData.setArrayA(Arrays.asList(1, 2, 3, 6, 7));
		seekerData.setArrayB(Arrays.asList(1, 2, 3, 4, 5));
	}

	@Test
	public void seekArraysIntersectionWithArrayAInSet() {
		seekerConfig.setArrayAIntoHashSet(true);
		seekerServiceImpl.findIntersection(new HashSet<Integer>(seekerData.getArrayA()), seekerData.getArrayB(),
				seekerData);
		assertEquals(3, seekerData.getResultSet().size());
	}

	@Test
	public void seekArraysIntersectionWithArrayBInSet() {
		seekerConfig.setArrayAIntoHashSet(false);
		seekerServiceImpl.findIntersection(new HashSet<Integer>(seekerData.getArrayB()), seekerData.getArrayA(),
				seekerData);
		assertEquals(3, seekerData.getResultSet().size());
	}

	@Test
	public void listShouldBeFillRandomly() {
		List<Integer> list = seekerServiceImpl.getRandomIntList(10);
		assertEquals(10, list.size());
	}

	@Test
	public void dataSeekerArraysShouldBePopulated() {
		seekerServiceImpl.populateData(seekerData, seekerConfig);
		assertEquals(seekerConfig.getArrayASize(), (Integer) seekerData.getArrayA().size());
		assertEquals(seekerConfig.getArrayBSize(), (Integer) seekerData.getArrayB().size());
	}

	@Test
	public void resultSetSizeShouldBeEquals() {
		seekerServiceImpl.populateData(seekerData, seekerConfig);
		seekerServiceImpl.findIntersection(new HashSet<Integer>(seekerData.getArrayB()), seekerData.getArrayA(),
				seekerData);
		seekerServiceImpl.findIntersectionNaiveMethod(seekerData);
		assertEquals(seekerData.getResultSet().size(), seekerData.getResultSetNaiveMethod().size());
	}
}
