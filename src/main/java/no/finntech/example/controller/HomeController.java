package no.finntech.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@Controller
@RequestMapping(value="/")
public final class HomeController {

    @RequestMapping(method = RequestMethod.GET)
	public ModelAndView get(final UriComponentsBuilder builder) throws IOException{
        return new ModelAndView("page.home", "urlToRandomPage", builder.path("/random").build().toString());
	}

}
