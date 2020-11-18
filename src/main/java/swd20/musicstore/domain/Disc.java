package swd20.musicstore.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Discs")
public class Disc {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String artist;
	private int releaseYear;
	private double price;
	private String genre;
	private int tracks;

	@ManyToOne
	@JsonIgnoreProperties("discs")
	@JoinColumn(name = "type_id")
	private Disctype disctype;
	
	
	public Disc() {
		super();
		this.id = null;
		this.title = null;
		this.artist = null;
		this.releaseYear = 0;
		this.price = 0;
		this.genre = null;
		this.tracks = 0;
	}



	public Disc(Long id, String title, String artist, int releaseYear, double price, String genre, int tracks,
			Disctype disctype) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.releaseYear = releaseYear;
		this.price = price;
		this.genre = genre;
		this.disctype = disctype;
		this.tracks = tracks;
		
	}


	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}


	public void setTitle(String title) {
		this.title = title;
	}



	public void setArtist(String artist) {
		this.artist = artist;
	}



	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}
	

	public void setTracks(int tracks) {
		this.tracks = tracks;
	}



	public void setDisctype(Disctype disctype) {
		this.disctype = disctype;
	}



	public String getTitle() {
		return title;
	}



	public String getArtist() {
		return artist;
	}


	public int getReleaseYear() {
		return releaseYear;
	}



	public double getPrice() {
		return price;
	}



	public String getGenre() {
		return genre;
	}
	

	public int getTracks() {
		return tracks;
	}


	public Disctype getDisctype() {
		return disctype;
	}



	@Override
	public String toString() {
		if (this.disctype != null)
		return "Disc [id=" + id + ", title=" + title + ", artist=" + artist + ", releaseYear=" + releaseYear
				+ ", price=" + price + ", genre=" + genre + ", tracks=" + ", disctype=" + this.getDisctype()
				+ "]";
		
		else
			return "Disc [id=" + id + ", title=" + title + ", artist=" + artist + ", releaseYear=" + releaseYear
					+ ", price=" + price + ", genre=" + genre + ", tracks=" + "]";
	}


	
}

