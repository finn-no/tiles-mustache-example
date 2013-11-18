package no.finntech.example.controller;

import no.finntech.example.model.RandomNumberView;
import no.finntech.example.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public final class RandomController {

    @Autowired
    private RandomService randomService;

    @RequestMapping(value = {"/random", "/random.json"})
    public ModelAndView get(final HttpServletRequest request) throws IOException {
        ModelAndView modelAndView = new ModelAndView("page.random");
        modelAndView.addObject("randoms", RandomNumberView.of(randomService.createListOfRandoms()));

        if (isJsonRequested(request)) {
            modelAndView.setView(createJsonView());
        }

        return modelAndView;
    }

    private View createJsonView() {
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
//        jsonView.setModelKey("randoms");  // used to filter which model keys gets serialized,
                                            // controlling size of payload when needed
        return jsonView;
    }

    private boolean isJsonRequested(final HttpServletRequest request) {
        return request.getRequestURI().endsWith(".json");
    }
}
