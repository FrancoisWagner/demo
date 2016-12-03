package com.wagner.demo.service;

import java.util.List;
import java.util.Set;

import com.wagner.demo.bean.SeekerConfig;
import com.wagner.demo.bean.SeekerData;

public interface SeekerService {
	public void populateData(SeekerData seekerData, SeekerConfig seekerConfig);

	public List<Integer> getRandomIntList(int size);

	public void findIntersectionNaiveMethod(SeekerData seekerData);

	public void findIntersection(Set<Integer> set, List<Integer> list, SeekerData seekerData);
}
