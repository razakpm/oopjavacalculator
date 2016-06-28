package com.cvtalks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestController {
    
    @RequestMapping(value="/calculator", method=RequestMethod.GET)
    public String requestForm(Model model) {
        model.addAttribute("request", new Request());
        return "submit";
    }
    
    @RequestMapping(value="/calculator", method=RequestMethod.POST)
    public String showResults(@ModelAttribute Request request, Model model) {
        model.addAttribute("request", request);
        try {
            request.getValue();
            return "result";
        } catch (Exception e) {
            return "invalid";
        }
    }

    @RequestMapping(value="/calculate")
    public String calculatePOSTstring(@RequestParam(value="value", required=true) String input, Model model) {
        Request request = new Request();
        request.setContent(input);
        model.addAttribute("request", request);
        try {
            request.getValue();
            return "result";
        } catch (Exception e) {
            return "invalid";
        }
    }
    
}