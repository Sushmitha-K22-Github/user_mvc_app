package org.jsp.usermvcapp.logoutcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class Logout {
	@RequestMapping("/logout")
public ModelAndView logout(HttpSession session) {
	session.invalidate();
	ModelAndView view =new ModelAndView();
	view.setViewName("login.jsp");
	view.addObject("msg", "You are logged out");
	return view;
}
}
