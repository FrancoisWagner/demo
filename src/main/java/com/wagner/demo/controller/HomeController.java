package com.wagner.demo.controller;

import java.util.HashSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wagner.demo.bean.SeekerConfig;
import com.wagner.demo.bean.SeekerData;
import com.wagner.demo.service.SeekerService;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private SeekerService seekerServiceImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute(new SeekerConfig(1000, 1000, true));
		return "home";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String run(@Valid SeekerConfig seekerConfig, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute(seekerConfig);
			return "home";
		}
		
		SeekerData seekerData = new SeekerData();
		seekerServiceImpl.populateData(seekerData, seekerConfig);
		this.seekArraysIntersection(seekerData, seekerConfig);
		model.addAttribute(seekerData);
		return "home";
	}

	public void seekArraysIntersection(SeekerData seekerData, SeekerConfig seekerConfig) {
		if (seekerConfig.getArrayAIntoHashSet()) {
			seekerServiceImpl.findIntersection(new HashSet<Integer>(seekerData.getArrayA()), seekerData.getArrayB(),
					seekerData);
		} else {
			seekerServiceImpl.findIntersection(new HashSet<Integer>(seekerData.getArrayB()), seekerData.getArrayA(),
					seekerData);
		}
		seekerServiceImpl.findIntersectionNaiveMethod(seekerData);
	}

}
