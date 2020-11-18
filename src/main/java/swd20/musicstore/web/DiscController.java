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


import swd20.musicstore.domain.Disc;
import swd20.musicstore.domain.DiscRepository;
import swd20.musicstore.domain.DisctypeRepository;

@CrossOrigin
@Controller
public class DiscController {

	@Autowired
	private DiscRepository repository;
	
	@Autowired
	private DisctypeRepository disctypeRepository;
	
	//show disclist
    @RequestMapping(value="/login")
    public String login() {	
        
    	return "login";
        
    }
	
    // SHOW DISCLIST
 	@RequestMapping(value= "/disclist", method = RequestMethod.GET)
 	public String getDiscs (Model model) {
 		model.addAttribute("discs", repository.findAll());
 		
 		return "disclist";
 	}
 	
 	// REST GET DISCS
    @RequestMapping(value="/discs", method = RequestMethod.GET)
    public @ResponseBody List<Disc> disclistRest() {	
        
    	return (List<Disc>) repository.findAll();
    }    
    
    // REST GET DISC BY ID
    @RequestMapping(value="/discs/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Disc> findDiscRest(@PathVariable("id") Long discId) {	
    	
    	return repository.findById(discId);
    } 
    
    // REST SAVE NEW DISC
    @RequestMapping(value="/discs", method = RequestMethod.POST)
    public @ResponseBody Disc saveDiscRest(@RequestBody Disc disc) {	
    	
    	return repository.save(disc);
    }
    
    // ADDING DISC
 	@RequestMapping(value = "/add", method = RequestMethod.GET)
 	public String addDisc(Model model) {
 		model.addAttribute("disc", new Disc());
 		model.addAttribute("disctypes", disctypeRepository.findAll());
 		
 		return "add_disc";	
 	}
 	
 	//SAVING A DISC
 	@RequestMapping(value = "/save", method = RequestMethod.POST)
 	public String save(Disc disc){
 		repository.save(disc);
 		        
 		return "redirect:disclist";
 		    
 	}
 		
 	//DELETING DISC
 	@PreAuthorize("hasAuthority('ADMIN')")
 	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
 	public String deleteDisc(@PathVariable("id") Long discId, Model model) {
 		repository.deleteById(discId);
 		
 		return "redirect:../disclist";
 	}
 	
 	//EDITING DISC
 	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
 	public String editDisc(@PathVariable("id") Long discId, Model model){
 		model.addAttribute("disc", repository.findById(discId));
 		model.addAttribute("disctypes", disctypeRepository.findAll());
 			
 		return "editdisc";	
 	}
 		
 		
 	
	
}

