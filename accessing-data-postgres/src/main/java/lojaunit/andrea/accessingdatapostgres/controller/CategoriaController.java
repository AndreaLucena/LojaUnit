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

import lojaunit.andrea.accessingdatapostgres.model.Categoria;
import lojaunit.andrea.accessingdatapostgres.repository.CategoriaRepository;


@Controller // This means that this class is a Controller
@RequestMapping(path="/categoria") // This means URL's start with /demo (after Application path)
public class CategoriaController {
	
	 @Autowired // This means to get the bean called userRepository
     // Which is auto-generated by Spring, we will use it to handle the data
	 private CategoriaRepository categoriaRepository;


	 @PostMapping(path="/add") // Map ONLY POST Requests
	 public @ResponseBody String addNewCategoria (@RequestParam String nome, boolean ativo) {
  
// @ResponseBody means the returned String is the response, not a view name
// @RequestParam means it is a parameter from the GET or POST request

		 Categoria n = new Categoria();
		 n.setNome(nome);
		 n.setAtivo(ativo);
		 
		  categoriaRepository.save(n);
		    return "Salvo";
		        
		  }

		  @GetMapping(path="/all")
		  public @ResponseBody Iterable<Categoria> getAllCategorias() {
		    // This returns a JSON or XML with the users
		    return categoriaRepository.findAll();
		  }
		  
		  @GetMapping(path="/find/{id}")
		  public @ResponseBody Optional<Categoria> findById(@RequestParam Integer idCategoria) {
		    // This returns a JSON or XML with this user
		    return categoriaRepository.findById(idCategoria);
		  }
		  @DeleteMapping(path="/delete/{id}")
		  public @ResponseBody String deleteById(@PathVariable (value="id") Integer idCategoria) {
			  //public @ResponseBody String deleteById @RequestParam Integer idCategoria?) {
		    // This returns a JSON or XML with this user
			  
			  if (categoriaRepository.findById(idCategoria) == null) {
				  return "Não encontrado";
			  }
			  categoriaRepository.deleteById(idCategoria);
			  return "Removido";
			  }
		  @PutMapping(path="/update/{id}")
		  public @ResponseBody String PutById( @PathVariable (value="id") Integer idCategoria, @RequestParam   String nome, boolean ativo) {
		    // This returns a JSON or XML with this user
			  
			  if (categoriaRepository.findById(idCategoria) == null) {
				  return "Não encontrado";
			  }
			  
			  Categoria n = new Categoria();
			  
			  n.setIdCategoria(idCategoria);
			  n.setNome(nome);
			  n.setAtivo(ativo);
			  
			    categoriaRepository.save(n);
			    return "Salvo";
		  }
		  
		}
