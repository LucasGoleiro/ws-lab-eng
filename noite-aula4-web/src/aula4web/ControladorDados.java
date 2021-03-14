package aula4web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorDados {
	
	@RequestMapping(value="/alunoJSON", 
					method=RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Pet> dadosPet(HttpServletResponse response) {
	    response.addHeader("Content-Type", "application/json");
	    
		Pet p1 = new Pet();
		p1.setId("003");
		p1.setNome("Thor");
		p1.setEspecie("Pastor alemão");
		p1.setRaca("pet");
		
		return ResponseEntity.ok(p1);
	}

}
