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
import br.edu.utfpr.aulaVraptor.dao.ProdutoDAO;
import br.edu.utfpr.aulaVraptor.model.Produto;

@Controller @Path("/produtos")
public class ProdutoController {
	
	@Inject private ProdutoDAO dao;
	@Inject private Result result;
	@Inject private Validator validator;
	
	@Get @Path("/novo")
	public void form() {
		
	}
	
	@Post
	public void adicionar(@Valid @NotNull Produto produto) {
		validator.onErrorForwardTo(this).form();
		dao.inserir(produto);
		result.redirectTo(this).listar();
	}
	
	@Get @Path("")
	public List<Produto> listar() {
		return dao.listAll();
	}
	
	@Get  @Path("/{produto.codigo}")
	public Produto visualizar(Produto produto) {
		return dao.load(produto.getCodigo());
	}
	
	@Put @Path("/{produto.codigo}")
	@IncludeParameters
	public void alterar(@Valid @NotNull Produto produto) {
		validator.onErrorForwardTo(this).visualizar(produto);
		dao.alterar(produto);
		result.redirectTo(this).listar();
	}
	
	@Delete @Path("/{produto.codigo}")
	public void remover(Produto produto) {
		dao.remover(Produto.class, produto.getCodigo());
		result.redirectTo(this).listar();
	}
	
	@Get @Path("/pesquisar")
	@IncludeParameters
	public void listar(Long codigo, String nome){
		if(codigo != null){
			result.redirectTo(this).visualizar(new Produto(codigo));
		}
		List<Produto> produtos = dao.list(nome);
		result.include("produtoList", produtos);
	}
	
	@Get @Path("/busca.json")
	public void buscaJson(String term) {
		List<Produto> categorias = dao.list(term);
		result.use(json()).withoutRoot().from(categorias).serialize();
	}
	
	@Get @Path("/lista.json")
	public void listaJson() {
		result.use(json()).withoutRoot().from(dao.listAll()).serialize();
	}
}
