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

import lojaunit.andrea.accessingdatapostgres.model.Faq;
import lojaunit.andrea.accessingdatapostgres.repository.FaqRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/faq") // This means URL's start with /demo (after Application path)
public class FaqController {
	
	 @Autowired // This means to get the bean called userRepository
     // Which is auto-generated by Spring, we will use it to handle the data
private FaqRepository faqRepository;

	  @PostMapping(path="/add") // Map ONLY POST Requests
	  public @ResponseBody String addNewFaq (@PathVariable (value="id") Integer idFaq, @RequestParam Date dataHora, String texto) {
		  
	    // @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request
		  
	    Faq n = new Faq();
	    n.setDataHora(dataHora);
	    n.setTexto(texto);
	    	    
	    faqRepository.save(n);
	    return "Salvo";
	        
	  }

	  @GetMapping(path="/all")
	  public @ResponseBody Iterable<Faq> getAllFaq() {
	    // This returns a JSON or XML with the users
	    return faqRepository.findAll();
	  }
	  @GetMapping(path="/find/{id}")
	  public @ResponseBody Optional<Faq> findById(@RequestParam Integer idFaq) {
	    // This returns a JSON or XML with this user
	    return faqRepository.findById(idFaq);
	  }
	  @DeleteMapping(path="/delete/{id}")
	  @ResponseStatus (code = HttpStatus.ACCEPTED)
	  public @ResponseBody String deleteById(@PathVariable Integer id) {
	    // This returns a JSON or XML with this user
		  
		  if (faqRepository.findById(id) == null) {
			  return "Não encontrado";
		  }
		 faqRepository.deleteById(id);
		  return "Removido";
		  }
	  @PutMapping(path="/update/{id}")
	  public @ResponseBody String PutById(@PathVariable Integer id,  Date dataHora, String texto) {
	    // This returns a JSON or XML with this user
		  
		  if (faqRepository.findById(id) == null) {
			  return "Não encontrado";
		  }
		  
		  Faq n = new Faq();
		    n.setDataHora(dataHora);
		    n.setTexto(texto);
		    	    
		    faqRepository.save(n);
		    return "Saved";
	  }
	}
