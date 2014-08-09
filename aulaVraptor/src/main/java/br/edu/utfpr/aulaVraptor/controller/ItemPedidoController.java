package br.edu.utfpr.aulaVraptor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.utfpr.aulaVraptor.model.ItemPedido;

@Controller
@Path("/itensPedido")
public class ItemPedidoController {
	
	@Inject private Result result;
	
	@Post
	public void adicionar(ItemPedido itemPedido) {
		
		result.redirectTo(PedidoController.class).form();
	}
}
