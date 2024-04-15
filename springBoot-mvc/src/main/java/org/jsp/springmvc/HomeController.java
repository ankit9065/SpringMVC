package org.jsp.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = "/open-home")
	public String openHomePage(Model model) {
		model.addAttribute("username", "Ankit Gupta");
		return "home";
	}

	@RequestMapping("/open-view")
	public String openView(@RequestParam(name = "view") String view) {
		return view;
	}

	@RequestMapping("/sum")
	public String findSum(@RequestParam(name = "num1") int num1, 
			@RequestParam(name = "num2") int num2, Model model) {
		
		model.addAttribute("result", num1 + "+" + num2 + "=" + (num1 + num2));
		return "print";
	}

	@RequestMapping("/diff")
	public String findDiff(@RequestParam(name = "num1") int num1, 
			@RequestParam(name = "num2") int num2, Model model) {
		
		model.addAttribute("result", num1 + "-" + num2 + "=" + (num1 - num2));
		return "print";
	}

	@RequestMapping("/product")
	public String findProduct(@RequestParam(name = "num1") int num1, 
			@RequestParam(name = "num2") int num2, Model model) {
		
		model.addAttribute("result", num1 + "*" + num2 + "=" + (num1 * num2));
		return "print";
	}

	@RequestMapping("/division")
	public String findDivision(@RequestParam(name = "num1") int num1, 
			@RequestParam(name = "num2") int num2, Model model) {
		
		model.addAttribute("result", num1 + "/" + num2 + "=" + (num1 / num2));
		return "print";
	}

	@RequestMapping("/large")
	public String findLarge(@RequestParam(name = "num1") int num1, 
			@RequestParam(name = "num2") int num2, Model model) {
		int ans;
		if (num1 > num2) {
			ans = num1;
		} 
		else {
			ans = num2;
		}
		model.addAttribute("result", ans);
		return "print";
	}

	@RequestMapping("/small")
	public String findSmall(@RequestParam(name = "num1") int num1, 
			@RequestParam(name = "num2") int num2, Model model) {
		int ans;
		if (num1 > num2) {
			ans = num2;
		} 
		else {
			ans = num1;
		}
		model.addAttribute("result", ans);
		return "print";
	}

//	@RequestMapping("/lcm")
//	public String findLcm(@RequestParam(name = "num1") int num1, 
//			@RequestParam(name = "num2") int num2, Model model) {
//		
//		model.addAttribute("result", num1 + "/" + num2 + "=" + (num1 / num2));
//		return "print";
//	}
//
//	@RequestMapping("/hcf")
//	public String findHcf(@RequestParam(name = "num1") int num1, 
//			@RequestParam(name = "num2") int num2, Model model) {
//		
//		model.addAttribute("result", num1 + "/" + num2 + "=" + (num1 / num2));
//		return "print";
//	}
	
	@RequestMapping(value = "/open-register")
	public ModelAndView openRegister() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("register");
		modelAndView.addObject("obj", new User());
		return modelAndView;
	}
	
	@RequestMapping(value = "/register")
	@ResponseBody
	public String register(@ModelAttribute(name = "obj") User user) {
		System.out.println(user);
		return "Details printed successfully";
	}
}
    
