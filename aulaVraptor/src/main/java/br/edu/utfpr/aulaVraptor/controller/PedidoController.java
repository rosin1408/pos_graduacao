package br.edu.utfpr.aulaVraptor.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.edu.utfpr.aulaVraptor.dao.PedidoDAO;
import br.edu.utfpr.aulaVraptor.model.Pedido;

@Controller
@Path("/pedidos")
public class PedidoController {
	
	@Inject private PedidoDAO dao;
	@Inject private Validator validator;
	@Inject private Result result;
	
	@Get @Path("/novo")
	public void form() {
	}
	
	@Post
	public void adicionar(@NotNull @Valid Pedido pedido) {
		validator.onErrorRedirectTo(this).form();
		dao.inserir(pedido);
		result.redirectTo(this).listar();
	}
	
	@Get @Path("")
	public List<Pedido> listar() {
		return dao.listAll();
	}
	
	@Get @Path("/{pedido.codigo}")
	public Pedido visualizar(Pedido pedido) {
		return dao.load(pedido.getCodigo());
	}
	
	@Put @Path("/pedido.codigo")
	@IncludeParameters
	public void alterar(Pedido pedido) {
		validator.onErrorRedirectTo(this).visualizar(pedido);
		dao.alterar(pedido);
		result.redirectTo(this).listar();
	}
	
	@Delete @Path("/pedido.codigo")
	public void remover(Pedido pedido) {
		dao.remover(Pedido.class, pedido.getCodigo());
	}
	
	@Get @Path("/pesquisar")
	@IncludeParameters
	public void listar(Long codigo, String numeroPedido) {
		if(codigo != null){
			result.redirectTo(this).visualizar(new Pedido(codigo));
		}
		List<Pedido> pedidos = dao.list(numeroPedido);
		result.include("pedidoList", pedidos);
	}
	
	@Get @Path("/busca.json")
	public void buscaJson(String term) {
		List<Pedido> pedidos = dao.list(term);
		result.use(json()).withoutRoot().from(pedidos).serialize();;
	}
}
