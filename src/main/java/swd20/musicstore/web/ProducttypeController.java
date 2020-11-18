package swd20.musicstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import swd20.musicstore.domain.Producttype;
import swd20.musicstore.domain.ProducttypeRepository;

@Controller
@CrossOrigin
public class ProducttypeController {
	
		@Autowired
		private ProducttypeRepository producttypeRepository;

		@RequestMapping(value= "/producttypelist", method = RequestMethod.GET)
		public String getProducttypes (Model model) {
			model.addAttribute("producttypes", producttypeRepository.findAll());
			return "producttypelist";
		}	
		
		// RESTful service to get all producttypes
	    @RequestMapping(value="/producttypes", method = RequestMethod.GET)
	    public @ResponseBody List<Producttype> getProducttypesRest() {	
	        return (List<Producttype>) producttypeRepository.findAll();
	    }    

		// RESTful service to get producttype by id
	    @RequestMapping(value="/producttypes/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Producttype> findProducttypeRest(@PathVariable("id") Long Id) {	
	    	return producttypeRepository.findById(Id);
	    } 
	    
	    // RESTful service to save new producttype
	    @RequestMapping(value="/producttypes", method = RequestMethod.POST)
	    public @ResponseBody Producttype saveProducttypeRest(@RequestBody Producttype producttype) {	
	    	return producttypeRepository.save(producttype);
	    }
	    
		@RequestMapping(value = "/createProducttype", method = RequestMethod.GET)
		public String createProducttype(Model model) {
			model.addAttribute("producttype", new Producttype());
			
			return "newproducttype";
			
		}
		
		@RequestMapping(value = "/savenewProducttype", method = RequestMethod.POST)
		 public String save(Producttype producttype){
			producttypeRepository.save(producttype);
		        
		    return "redirect:producttypelist";
		    
		}
}
