package br.com.rosin.posgraduacao.projetopos.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {
	
	@Inject
	private Result result;
	
	@Path("/")
	public void index() {
		System.out.println("tá no caminho!!!");
	}
	
	public void ola(){
		result.include("teste", "Valor que veio do Controller!!");
	}
}
