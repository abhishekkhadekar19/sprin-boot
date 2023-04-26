package com.springboot.web.controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class MainController {

	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("rollno", "18004006");
	}

	@ModelAttribute
	public void modelData2(Model m) {
		m.addAttribute("rollno1", "184004006");
	}

	@RequestMapping("/")
	public String home() {
		System.out.println("this is home page");
		return "home";
	}

	@RequestMapping("/contact")
	public String contact() {
		System.out.println("this is contact page");
		return "contact";
	}

	// first way to do stuff and create api
	// @RequestMapping("/add")
	// public String add(HttpServletRequest req) {
	// int i = Integer.parseInt(req.getParameter("num1"));
	// int j = Integer.parseInt(req.getParameter("num2"));
	// int num3 = i + j;
	// HttpSession session = req.getSession();
	// session.setAttribute("num3", num3);
	// return "result";
	// }
	// @RequestMapping("/add")
	// public String add(@RequestParam("num1") int i, @RequestParam("num2") int j,
	// HttpSession session) {

	// int num3 = i + j;
	// session.setAttribute("num3", num3);
	// return "result";
	// }
	// USING MODELVIEW
	// @RequestMapping("/add")
	// public ModelAndView add(@RequestParam("num1") int i, @RequestParam("num2")
	// int j) {
	// ModelAndView mv = new ModelAndView();
	// mv.setViewName("result");
	// int num3 = i + j;
	// mv.addObject("num3", num3);
	// return mv;
	// }

	// using model and modelMap
	@RequestMapping("/add")
	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, ModelMap m) {
		int num3 = i + j;
		m.addAttribute("num3", num3);
		return "result";
	}

	// @RequestMapping("addAlien")
	// public String addAlien(@RequestParam("aid") int aid, @RequestParam("aname")
	// String aname, Model m) {
	// Alien a = new Alien();
	// a.setAid(aid);
	// a.setAname(aname);
	// m.addAttribute("Alien", a);
	// return "result";
	// }
	// in order to avoid above the addalien operation we will using modelattribute
	@RequestMapping("addAlien")
	public String addAlien(@ModelAttribute("b1") Alien a) {
		// public String addAlien(@ModelAttribute("a1") Alien a) {
		// you can @modelAttribute(a1) Alien a also so u have to to pass

		return "result";
	}

	// @GetMapping("getAliens")
	// public String getAliens(Model m){
	// List<Alien> aliens = Arrays.asList(new Alien(102, "NA22IN"), new Alien(101,
	// "NAVIN"));
	// m.addAttribute("result1", aliens);
	// return "showaliens";
	// }
	// USE of patha variable
	@RequestMapping("result/{name}/message/{mes}")
	public Alien Alien3(@PathVariable String name, @PathVariable String mes) {
		return new Alien("hello world id is" + name, "hello aname" + mes);
	}

	@RequestMapping("customResult/{result}/{id}/{productName}")
	public Alien Alien4(@PathVariable String result, @PathVariable int id, @PathVariable String productName) {
		return new Alien("here is result " + result + "id is " + id, "the product name is " + productName);
	}
}