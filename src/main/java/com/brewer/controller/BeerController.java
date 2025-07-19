package com.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BeerController {

	@RequestMapping("/beer/newBeer")
	public String newBeer(){
		return "/beer/beerRegistration";
	}
	@RequestMapping(value = "/beer/newBeer", method = RequestMethod.POST)
	public String registration(String sku) {
		System.out.println("What");
		System.out.println("What is a:" + sku);
		return "/beer/beerRegistration";
	}
}
