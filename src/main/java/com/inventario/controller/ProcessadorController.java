package com.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inventario.models.ProcessadorModel;
import com.inventario.service.ProcessadorService;

@Controller
public class ProcessadorController {
	
	@Autowired
	ProcessadorService processadorService;
	
//	@RequestMapping(value="/processadores", method = RequestMethod.GET)
//	public ModelAndView getProcessadores() {
//		ModelAndView mv = new ModelAndView("processadores");
//		List<ProcessadorModel> processadores = processadorService.findAll();
//		mv.addObject("processadores", processadores);
//		return mv;
//	}
	
	@RequestMapping(value="/processadores", method = RequestMethod.GET)
	public String getPostProcessadores() {
		return "processadores";
	}
	
	@RequestMapping(value="/processadores", method = RequestMethod.POST)
	public String salvarProcessador(ProcessadorModel processadorModel, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return "redirect:/processadores";
		}
		processadorService.save(processadorModel);
		return "redirect:/processadores";
	}
}
