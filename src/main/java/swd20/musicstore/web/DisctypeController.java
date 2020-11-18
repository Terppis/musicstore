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

import swd20.musicstore.domain.Disctype;
import swd20.musicstore.domain.DisctypeRepository;

@Controller
@CrossOrigin
public class DisctypeController {
	@Autowired
	private DisctypeRepository disctypeRepository;

	@RequestMapping(value= "/disctypelist", method = RequestMethod.GET)
	public String getDisctypes (Model model) {
		model.addAttribute("disctypes", disctypeRepository.findAll());
		return "disctypelist";
	}	
	
	// RESTful service to get all disctypes
    @RequestMapping(value="/disctypes", method = RequestMethod.GET)
    public @ResponseBody List<Disctype> getDisctypesRest() {	
        return (List<Disctype>) disctypeRepository.findAll();
    }    

	// RESTful service to get disctype by id
    @RequestMapping(value="/disctypes/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Disctype> findDisctypeRest(@PathVariable("id") Long typeId) {	
    	return disctypeRepository.findById(typeId);
    } 
    
    // RESTful service to save new disctype
    @RequestMapping(value="/disctypes", method = RequestMethod.POST)
    public @ResponseBody Disctype saveDisctypeRest(@RequestBody Disctype disctype) {	
    	return disctypeRepository.save(disctype);
    }
    
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createDisctype(Model model) {
		model.addAttribute("disctype", new Disctype());
		
		return "newdisctype";
		
	}
	
	@RequestMapping(value = "/savenew", method = RequestMethod.POST)
	 public String save(Disctype disctype){
	    disctypeRepository.save(disctype);
	        
	    return "redirect:disctypelist";
	    
	}
}
