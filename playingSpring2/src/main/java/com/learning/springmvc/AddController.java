package com.learning.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.learning.service.AddService;

@Controller
public class AddController {
	
	@RequestMapping(value= "/add", method = RequestMethod.GET)
	public ModelAndView add(@RequestParam("t1") int i, @RequestParam("t2") int j) {
		
		/*
		 * //Removing httpservlet request response with @RequestParam annotation
		 * provided by Spring public ModelAndView add(HttpServletRequest request,
		 * HttpServletResponse response) int i =
		 * Integer.parseInt(request.getParameter("t1")); int j =
		 * Integer.parseInt(request.getParameter("t2"));
		 */
		
		AddService as = new AddService();
		int k = as.add(i, j);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		mv.addObject("result", k);
		return mv;
	}
}
