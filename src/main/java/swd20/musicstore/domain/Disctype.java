package swd20.musicstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name = "disctypes")
@Entity
public class Disctype {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long type_id;
	private String discType;
	
	@JsonIgnoreProperties ("disctypes")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "disctype")
	private List <Disc> discs;

	
	public Disctype() {
		
	}


	public Disctype(String discType) {
		super();
		this.discType = discType;
	}


	public Long getType_id() {
		return type_id;
	}
	

	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}


	public void setDiscType(String discType) {
		this.discType = discType;
	}


	public void setDiscs(List<Disc> discs) {
		this.discs = discs;
	}


	public String getDiscType() {
		return discType;
	}


	public List<Disc> getDiscs() {
		return discs;
	}


	@Override
	public String toString() {
		return "Disctype [type_id=" + type_id + ", discType=" + discType + "]";
	}
	
	
	
	
	
	
}
