package lojaunit.andrea.accessingdatapostgres.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lojaunit.andrea.accessingdatapostgres.model.Produto;
import lojaunit.andrea.accessingdatapostgres.repository.ProdutoRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/produto") // This means URL's start with /demo (after Application path)
public class ProdutoController {

	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private ProdutoRepository produtoRepository;


	  @PostMapping(path="/add") // Map ONLY POST Requests
	  public @ResponseBody String addNewProduto (@RequestParam String nome
	      , @RequestParam String descricao, double preco_unitario, Integer unidade) {
		  
	    // @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request

	    Produto n = new Produto();
	    n.setNome(nome);
	    n.setDescricao(descricao);
	    n.setPreco_unitario(preco_unitario);
	    n.setUnidade(unidade);
	    	    
	    produtoRepository.save(n);
	    return "Salvo";
	        
	  }

	  @GetMapping(path="/all")
	  public @ResponseBody Iterable<Produto> getAllProdutos() {
	    // This returns a JSON or XML with the users
	    return produtoRepository.findAll();
	  }
	  @GetMapping(path="/find/{id}")
	  public @ResponseBody Optional<Produto> findById(@RequestParam Integer idProduto) {
	    // This returns a JSON or XML with this user
	    return produtoRepository.findById(idProduto);
	  }
	  @DeleteMapping(path="/delete/{id}")
	  public @ResponseBody String deleteById(@RequestParam Integer idProduto) {
	    // This returns a JSON or XML with this user
		  
		  if (produtoRepository.findById(idProduto) == null) {
			  return "Não encontrado";
		  }
		  produtoRepository.deleteById(idProduto);
		  return "Removido";
		  }
	  @PutMapping(path="/update/{id}")
	  public @ResponseBody String PutById(@PathVariable (value="id") Integer Produto, @RequestParam String nome, String descricao, double preco_unitario, Integer unidade, Integer idProduto) {
	    // This returns a JSON or XML with this user
		  
		  if (produtoRepository.findById(idProduto) == null) {
			  return "Não encontrado";
		  }
		  
		  Produto n = new Produto();
		    n.setNome(nome);
		    n.setDescricao(descricao);
		    n.setPreco_unitario(preco_unitario);
		    n.setUnidade(unidade);
		    	    
		    produtoRepository.save(n);
		    return "Saved";
		        
	  }
	  
	}