package swd20.musicstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import swd20.musicstore.domain.Fanproduct;
import swd20.musicstore.domain.FanproductRepository;
import swd20.musicstore.domain.ProducttypeRepository;

@CrossOrigin
@Controller
public class FanproductController {

	
	@Autowired
	private FanproductRepository productrepository;
	
	@Autowired
	private ProducttypeRepository producttypeRepository;
	
	
	//show product list
    @RequestMapping(value="/login2")
    public String login() {	
        
    	return "login";
        
    }
    // SHOW PRODUCT LIST
 	@RequestMapping(value= "/fanproductlist", method = RequestMethod.GET)
 	public String getFanproducts (Model model) {
 		model.addAttribute("fanproducts", productrepository.findAll());
 		
 		return "fanproductlist";
 	}
 	
 	// REST GET PRODUCTS
    @RequestMapping(value="/fanproducts", method = RequestMethod.GET)
    public @ResponseBody List<Fanproduct> fanproductlistRest() {	
        
    	return (List<Fanproduct>) productrepository.findAll();
    }    
    
    // REST GET PRODUCT BY ID
    @RequestMapping(value="/fanproducts/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Fanproduct> findFanproductRest(@PathVariable("id") Long Id) {	
    	
    	return productrepository.findById(Id);
    } 
    
    // REST SAVE NEW PRODUCT
    @RequestMapping(value="/fanproducts", method = RequestMethod.POST)
    public @ResponseBody Fanproduct saveFanproductRest(@RequestBody Fanproduct fanproduct) {	
    	
    	return productrepository.save(fanproduct);
    }
    
    // ADDING PRODUCT
 	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
 	public String addFanproduct(Model model) {
 		model.addAttribute("fanproduct", new Fanproduct());
 		model.addAttribute("producttypes", producttypeRepository.findAll());
 		
 		return "addfanproduct";	
 	}
 	
 	//SAVING A PRODUCT
 	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
 	public String save(Fanproduct fanproduct){
 		productrepository.save(fanproduct);
 		        
 		return "redirect:fanproductlist";
 		    
 	}
 		
 	//DELETING PRODUCT
 	@PreAuthorize("hasAuthority('ADMIN')")
 	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET)
 	public String deleteFanproduct(@PathVariable("id") Long Id, Model model) {
 		productrepository.deleteById(Id);
 		
 		return "redirect:../fanproductlist";
 	}
 	
 	//EDITING PRODUCT
 	@RequestMapping(value = "/editProduct/{id}", method = RequestMethod.GET)
 	public String editFanproduct(@PathVariable("id") Long Id, Model model){
 		model.addAttribute("fanproduct", productrepository.findById(Id));
 		model.addAttribute("producttypes", producttypeRepository.findAll());
 			
 		return "editfanproduct";	
 	}
}
