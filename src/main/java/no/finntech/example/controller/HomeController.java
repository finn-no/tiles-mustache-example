package no.finntech.example.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public final class HomeController {

    @RequestMapping(method = RequestMethod.GET)
	public ModelAndView get() throws IOException{
		return new ModelAndView("page.home");
	}

}
