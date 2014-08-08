package br.edu.utfpr.aulaVraptor.controller;

import java.util.ArrayList;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.utfpr.aulaVraptor.model.ItemPedido;
import br.edu.utfpr.aulaVraptor.model.Pedido;

@Controller
@Path("/itensPedido")
public class ItemPedidoController {
	
	@Inject private Result result;
	@Inject private Pedido pedido;
	
	@Post
	public void adicionar(ItemPedido itemPedido) {
		
		if (pedido.getItensPedido() == null) {
			pedido.setItensPedido(new ArrayList<ItemPedido>());
		}
		pedido.getItensPedido().add(itemPedido);
		result.redirectTo(PedidoController.class).form();
	}
}
