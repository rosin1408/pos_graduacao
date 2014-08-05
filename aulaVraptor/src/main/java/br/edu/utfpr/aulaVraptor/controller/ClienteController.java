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
import br.edu.utfpr.aulaVraptor.dao.ClienteDAO;
import br.edu.utfpr.aulaVraptor.model.Cliente;

@Controller
@Path("/clientes")
public class ClienteController {

	@Inject
	private ClienteDAO dao;
	@Inject
	private Result result;
	@Inject
	private Validator validator;
	
	@Get
	@Path("/novo")
	public void form(){
	}

	@Post
	public void adicionar(@NotNull @Valid Cliente cliente) {
		validator.onErrorForwardTo(this).form();
		dao.inserir(cliente);
        result.redirectTo(this).listar();
    }
	
	@Delete
	@Path("/{cliente.codigo}")
	public void remover(Cliente cliente) {
        dao.remover(cliente.getCodigo());
        result.redirectTo(this).listar();
    }
	
	@Put
	@Path("/{cliente.codigo}")
	public void alterar(Cliente cliente) {
        dao.alterar(cliente);
        result.redirectTo(this).listar();
    }
	
	@Get
	@Path("/{cliente.codigo}")
    public Cliente visualizar(Cliente cliente) {
        return dao.load(cliente.getCodigo());
    }

	@Get
	@Path("")
    public List<Cliente> listar() {
        return dao.listAll();
    }
	
	@Get
	@Path("/pesquisar")
	@IncludeParameters
	public void listar(Long codigo, String nome){
		if(codigo != null){
			result.redirectTo(this).visualizar(new Cliente(codigo));
		}
		List<Cliente> clientes = dao.list(nome);
		result.include("clienteList", clientes);
	}
	
	@Get
	@Path("/busca.json")
	public void buscaJson(String term){
		List<Cliente> clientes = dao.list(term);
		result.use(json()).withoutRoot().from(clientes).serialize();
	}
}
