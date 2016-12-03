package com.wagner.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.wagner.demo.bean.SeekerConfig;
import com.wagner.demo.bean.SeekerData;

@Component
public class SeekerServiceImpl implements SeekerService {
	public void populateData(SeekerData seekerData, SeekerConfig seekerConfig) {
		seekerData.setArrayA(getRandomIntList(seekerConfig.getArrayASize()));
		seekerData.setArrayB(getRandomIntList(seekerConfig.getArrayBSize()));
	}

	public List<Integer> getRandomIntList(int size) {
		List<Integer> list = new ArrayList<Integer>();
		Random generator = new Random();
		int maxNumber = size * 10;

		while (size > 0) {
			list.add(generator.nextInt(maxNumber));
			size--;
		}

		return list;
	}

	public void findIntersectionNaiveMethod(SeekerData seekerData) {
		Set<Integer> resultSet = new HashSet<Integer>();

		for (Integer item : seekerData.getArrayA()) {
			for (Integer item2 : seekerData.getArrayB()) {
				if (item.equals(item2)) {
					resultSet.add(item);
				}
			}
		}
		seekerData.setResultSetNaiveMethod(resultSet);
	}

	public void findIntersection(Set<Integer> set, List<Integer> list, SeekerData seekerData) {
		Set<Integer> resultSet = new HashSet<Integer>();

		for (Integer item : list) {
			if (set.contains(item)) {
				resultSet.add(item);
			}
		}
		seekerData.setResultSet(resultSet);
	}

}
