package org.jsp.usermvcapp.controller;

import org.jsp.usermvcapp.dao.UserDao;
import org.jsp.usermvcapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(names= {"u"})
public class UserController {
	@Autowired
	private UserDao dao;
	@PostMapping("/save")
public ModelAndView saveUser(@ModelAttribute User user,ModelAndView view) {
	view.setViewName("print.jsp");
	user=dao.saveUser(user);
	view.addObject("msg", "user saved with ID:"+user.getId());
	return view;
}
	@PostMapping("/update")
	public ModelAndView updateUser(@ModelAttribute User user,ModelAndView view) {
		view.addObject("u",user);
		user=dao.updateUser(user);
		view.addObject("msg", "user updated with ID:"+user.getId());
		view.setViewName("print.jsp");
		return view;
	}
	@PostMapping("/login")
	public ModelAndView login(@RequestParam long phone,@RequestParam String password) {
		User user=dao.verifyUser(phone, password);
		ModelAndView view =new 	ModelAndView();
		if(user!=null) {
			view.addObject("u", user);
			view.setViewName("home.jsp");
			return view;
		}else {
			view.addObject("msg", "Invalid phone or password");
			view.setViewName("login.jsp");
			return view;
		}
	}
	@RequestMapping("/delete")
	public ModelAndView deleteUser(@RequestParam int id, ModelAndView view) {
		boolean isDeleted=dao.deleteUser(id);
		if(isDeleted) {
			view.setViewName("login.jsp");
			view.addObject("msg", "your account is deleted");
			return view;
		}else {
			view.setViewName("login.jsp");
			view.addObject("msg", "you must login to delete");
			return view;
		}
		
	}
}
