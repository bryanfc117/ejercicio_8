package py.edu.facitec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import py.edu.facitec.model.Tienda;
import py.edu.facitec.repository.TiendaRepository;

@Controller
public class TiendaController {
	@Autowired
	private TiendaRepository tiendaRepository;
	
	@RequestMapping("/form_tienda")
	public String metodo() {
		
		return "/view/tienda/form";
	}
	
	@RequestMapping(value = "/registrar_tienda", method = RequestMethod.POST)
	public ModelAndView registrar(Tienda tienda) {
		
		tiendaRepository.save(tienda);
		System.out.println("Tienda registrada con éxito");
		
		return new ModelAndView("redirect:form_tienda");
	}
}
