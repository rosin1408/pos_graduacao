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
import br.edu.utfpr.aulaVraptor.dao.CategoriaDAO;
import br.edu.utfpr.aulaVraptor.model.Categoria;

@Controller
@Path("/categorias")
public class CategoriaController {
	
	@Inject
	private CategoriaDAO dao;
	
	@Inject
	private Validator validator;
	
	@Inject
	private Result result;
	
	@Get
	@Path("/novo")
	public void form() {
	}
	
	@Post
	public void adicionar(@NotNull @Valid Categoria categoria) {
		validator.onErrorForwardTo(this).form();
		dao.inserir(categoria);
		result.redirectTo(this).listar();
	}
	
	@Delete
	@Path("/{categoria.codigo}")
	public void remover(Categoria categoria) {
		dao.remover(Categoria.class, categoria.getCodigo());
		result.redirectTo(this).listar();
	}
	
	@Put
	@Path("/{categoria.codigo}")
	public void alterar(Categoria categoria) {
		dao.alterar(categoria);
		result.redirectTo(this).listar();
	}
	
	@Get
	@Path("/{categoria.codigo}")
	public Categoria visualizar(Categoria categoria) {
		return dao.load(categoria.getCodigo());
	}
	
	@Get
	@Path("")
    public List<Categoria> listar() {
        return dao.listAll();
    }
	
	@Get
	@Path("/pesquisar")
	@IncludeParameters
	public void listar(Long codigo, String nome) {
		if (codigo != null) {
			result.redirectTo(this).visualizar(new Categoria(codigo));
		}
		List<Categoria> categorias = dao.list(nome);
		result.include("categoriaList", categorias);
	}
	
	@Get
	@Path("/busca.json")
	public void buscaJson(String term) {
		List<Categoria> categorias = dao.list(term);
		result.use(json()).withoutRoot().from(categorias).serialize();
	}
}
