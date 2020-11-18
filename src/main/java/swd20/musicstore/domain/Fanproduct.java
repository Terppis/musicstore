package swd20.musicstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Fanproduct {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String productName;
	private double price;
	private String artist;
	private String product;
	
	@ManyToOne
	@JsonIgnoreProperties("Fanproducts")
	@JoinColumn(name = "pType_id")
	private Producttype producttype;

	
	
	public Fanproduct() {
		super();
		this.id = null;
		this.productName = null;
		this.price = 0;
		this.artist = null;
		this.product = null;
	}



	public Fanproduct(Long id, String productName, double price, String artist, String product, Producttype producttype) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.artist = artist;
		this.product = product;
		this.producttype = producttype;
	}



	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public void setPrice(double price) {
		this.price = price;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}



	public void setProduct(String product) {
		this.product = product;
	}
	
	public void setProducttype(Producttype producttype) {
		this.producttype = producttype;
	}



	public String getProductName() {
		return productName;
	}



	public double getPrice() {
		return price;
	}
	
	
	public String getArtist() {
		return artist;
	}



	public String getProduct() {
		return product;
	}
	
	public Producttype getProducttype() {
		return producttype;
	}


	@Override
	public String toString() {
		if (this.producttype !=  null)
		return "Fanproduct [id=" + id + ", productName=" + productName + ", price=" + price + ", artist=" + artist + ", product=" + product +", producttype="
				 + this.getProducttype() + "]";
		
		else 
			return "Fanproduct [id=" + id + ", productName=" + productName + ", price=" + price + ", artist=" + artist + ", product=" + product +"]";
	}
	
	
	}
