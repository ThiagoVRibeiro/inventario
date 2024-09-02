package com.inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inventario.models.ProcessadorModel;
import com.inventario.service.ProcessadorService;

import jakarta.validation.Valid;

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
	
//	@RequestMapping(value="/processadores", method = RequestMethod.GET)
//	public String getProcessadoresForm() {
//		return "processadores";
//	}
	
	@RequestMapping(value="/processadores", method = RequestMethod.POST)
	public String salvarProcessador(@Valid ProcessadorModel processadorModel, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return "redirect:/processadoress";
		}
		processadorService.save(processadorModel);
		return "redirect:/processadores";
	}
	
	@GetMapping("processadores")
	public String listarProcessadores(Model model) {
		List<ProcessadorModel> processadorModel = processadorService.listarProcessadores();
		model.addAttribute("processadores", processadorModel);
		return "/processadores";
	}
	
	@GetMapping("/apagar/{id}")
	public String apagarProcessador(@PathVariable("id") long id) {
		System.out.println("ID: " + id);
		return "redirect:/processadores";
	}
}
