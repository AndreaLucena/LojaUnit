package lojaunit.andrea.accessingdatapostgres.controller;
import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lojaunit.andrea.accessingdatapostgres.model.Vendas;
import lojaunit.andrea.accessingdatapostgres.repository.VendasRepository;


@Controller // This means that this class is a Controller
@RequestMapping(path="/vendas") // This means URL's start with /demo (after Application path)
public class VendasController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private VendasRepository vendasRepository;


  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewVendas (@RequestParam double valor_total, Date dataHora) {
	  
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    Vendas n = new Vendas();
    n.setValor_total(valor_total);
    n.setDataHora(dataHora);
        
    vendasRepository.save(n);
    return "Salvo";
        
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Vendas> getAllVendas() {
    // This returns a JSON or XML with the users
    return vendasRepository.findAll();
  }
  @GetMapping(path="/find/{id}")
  public @ResponseBody Optional<Vendas> findById(@RequestParam Integer idVendas) {
    // This returns a JSON or XML with this user
    return vendasRepository.findById(idVendas);
  }
  @DeleteMapping(path="/delete/{id}")
  @ResponseStatus (code = HttpStatus.ACCEPTED)
  public @ResponseBody String deleteById(@PathVariable Integer id) {
    // This returns a JSON or XML with this user
	  
	  if (vendasRepository.findById(id) == null) {
		  return "Não encontrado";
	  }
	  vendasRepository.deleteById(id);
	  return "Removido";
	  }
  @PutMapping(path="/update/{id}")
  public @ResponseBody String PutById(@PathVariable Integer id, double valor_total, Date dataHora) {
    // This returns a JSON or XML with this user
	  
	  if (vendasRepository.findById(id) == null) {
		  return "Não encontrado";
	  }
	  
	  Vendas n = new Vendas();
	    n.setValor_total(valor_total);
	    n.setDataHora(dataHora);
	        
	    vendasRepository.save(n);
	    return "Salvo";
  }
}
