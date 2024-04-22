package com.example.To.Do.App.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.To.Do.App.model.todo_list;
import com.example.To.Do.App.service.TodoService;

import jakarta.persistence.Id;

@Controller
public class todocontroller {
	@Autowired
	private TodoService service;

	@GetMapping({"/","/viewlist"})
    public String viewtodolist(Model model, @ModelAttribute ("massage") String massage)
  { 
    	
		model.addAttribute("list",service.getAlltodolist());
        model.addAttribute("massage", massage);
	    return "viewlist";
  }
   @PostMapping("/updatetodo/{id}")
  public String updatetodolist(@PathVariable long id,RedirectAttributes rd)
  {
	   if(service.updatelist(id))
	   {
		   rd.addFlashAttribute("massage","updatesuccess");
		   return "redirect:/viewlist";
	   }
	   rd.addFlashAttribute("massage","update failuar");
	  return "redirect:/viewlist";
  }
  
   @GetMapping("/addlist")
  public String addtodolist(Model model)
  {
	   model.addAttribute("todo", new todo_list());
	  return "addlist";
  }
  @PostMapping("/savelist")
  public String savetodolist(todo_list todo , RedirectAttributes rd)
  {
	  if(service.SaveOrUpdatelist(todo))
	  {
		  rd.addAttribute("massage","save listsuccess");
		  return "redirect:/viewlist";
	  }
	  return "redirect:/addlist";
  }
  @GetMapping("/edittodo/{id}")
  public String edittodolist(@PathVariable long id , Model model)
  {
	  model.addAttribute("todo",service .gettodolistbyid(id));
	  return "/edittodo";
  }
  @PostMapping("/editsavelist")
  public String editsavetodolist(todo_list todo ,RedirectAttributes rd)
  {
	  if(service.SaveOrUpdatelist(todo))
	  {
		  rd.addFlashAttribute("massage","editsuccess");
	  return "rediret:/viewlist";
  }
	  return "redirect:/edittodo";
}
  @GetMapping("/delete/{id}")
  public String deletelist(@PathVariable long id , RedirectAttributes rd)
  {
	  if(service.deletetodolist(id))
	  {
		  rd.addFlashAttribute("massage","delete list");
	  }
	  rd.addFlashAttribute("massage","delete failed");
	  return "rediret:/viewlist";
	  
  }
  
  }
