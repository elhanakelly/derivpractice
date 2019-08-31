package com.lanak.derivapp;

import javax.servlet.http.HttpServletRequest; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class MyController {

	Polynomial poly = new Polynomial(); 
	String expression = poly.expressionForHTML(); 
	
	//to get answer form page 
	@RequestMapping(value="/", method=RequestMethod.GET )
	public String getAnswerForm(HttpServletRequest request, Model model) {
		//return html page name 
		model.addAttribute("expression", expression);
		return "index";
	} 
	
	//checking answer
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String answer(@ModelAttribute(name="answerForm") AnswerForm answerForm, Model model ) { 
		String compare = answerForm.getAnswer().trim().replaceAll("\\s+", "");
		if(compare.equalsIgnoreCase(poly.derivNoSpace().trim())) {
			poly = new Polynomial();
			expression = poly.expressionForHTML();
			return "temp"; //replace with success page that then redirects to practice 
		}
		model.addAttribute("wrongAnswer", true);
		poly = new Polynomial();
		expression = poly.expressionForHTML();
		return "wrong"; //replace with incorrect answer page that then redirects to practice 
	}
}
