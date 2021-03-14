package aula4web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controlador {
	
	@GetMapping("/hello")
	public String hello() { 
		return "index";
	}
	
	@GetMapping("/pet")
	public ModelAndView aluno() { 
		
		Pet p1 = new Pet();
		p1.setId("001");
		p1.setNome("Totó");
		p1.setEspecie("Labrador");
		p1.setRaca("Cachorro");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pet");
		mv.addObject("pet1", p1);
		
		return mv;
	}
}