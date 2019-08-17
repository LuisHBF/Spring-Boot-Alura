package controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Curso;
import model.Topico;

@Controller
public class TopicosController {

	@RequestMapping("/topicos")
	@ResponseBody
	public List<Topico> lista(){
		Topico topico = new Topico("Duvida","Duvida com Spring", new Curso("Spring","Programação"));
		
		return Arrays.asList(topico,topico,topico);
	}
	
}
