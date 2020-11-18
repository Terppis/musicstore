package swd20.musicstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Producttype {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ptype_id;
	private String productType;
	
	
	@JsonIgnoreProperties("Producttypes")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "producttype")
	private List <Fanproduct> fanproducts;


	public Producttype() {
	
	}


	public Producttype(String productType) {
		super();
		this.productType = productType;
	}


	public Long getPtype_id() {
		return ptype_id;
	}


	public void setPtype_id(Long ptype_id) {
		this.ptype_id = ptype_id;
	}


	public void setProductType(String productType) {
		this.productType = productType;
	}


	public void setFanproducts(List<Fanproduct> fanproducts) {
		this.fanproducts = fanproducts;
	}


	public String getProductType() {
		return productType;
	}


	public List<Fanproduct> getFanproducts() {
		return fanproducts;
	}


	@Override
	public String toString() {
		return "Producttype [ptype_id=" + ptype_id + ", productType=" + productType + "]";
	}
	
	
	
	
}


