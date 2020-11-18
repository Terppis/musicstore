package swd20.musicstore;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd20.musicstore.domain.Disc;
import swd20.musicstore.domain.DiscRepository;
import swd20.musicstore.domain.Disctype;
import swd20.musicstore.domain.DisctypeRepository;
import swd20.musicstore.domain.Fanproduct;
import swd20.musicstore.domain.FanproductRepository;
import swd20.musicstore.domain.Producttype;
import swd20.musicstore.domain.ProducttypeRepository;


@SpringBootApplication
public class MusicstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(DiscRepository discRepository, DisctypeRepository disctypeRepository, FanproductRepository fanproductRepository, ProducttypeRepository producttypeRepository ) {
		return (args) -> {
			
			
			
			Disctype type1= new Disctype("LP");
			disctypeRepository.save(type1);
			Disctype type2= new Disctype("CD");
			disctypeRepository.save(type2);
			Disctype type3= new Disctype("Mini LP");
			disctypeRepository.save(type3);
		
			discRepository.save(new Disc(null, "After Hours", "The Weeknd", 2020, 37.99, "R&B", 14, type1));
			discRepository.save(new Disc(null, "Dire Straits", "Dire Straits", 1978, 9.99, "Rock", 9, type2));
			discRepository.save(new Disc(null, "Rumours", "Fleetwood Mac", 1977, 21.99, "Rock", 11, type1));
			discRepository.save(new Disc(null, "The Slow Rush", "Tame Impala", 2020, 31.99, "Psychedelic pop", 12, type1));
			discRepository.save(new Disc(null, "Trilogy", "The Weeknd", 2012, 599.99, "Dark R&B", 30, type1));
			
			Producttype ptype1= new Producttype("Clothing");
			producttypeRepository.save(ptype1);
			Producttype ptype2= new Producttype("Accessories");
			producttypeRepository.save(ptype2);
			Producttype ptype3= new Producttype("Shoes");
			producttypeRepository.save(ptype3);
			
			fanproductRepository.save(new Fanproduct(null, "XO Logo After Hours Sweater", 41.99, "The Weeknd", "Sweater", ptype1));
			fanproductRepository.save(new Fanproduct(null, "Rumours T-shirt", 24.99, "Fleetwood Mac", "T-shirt", ptype1));
			fanproductRepository.save(new Fanproduct(null, "XO Classic Hoodie", 44.99, "The Weeknd", "Hoodie", ptype1));
			fanproductRepository.save(new Fanproduct(null, "After Hours Playing Cards", 14.99, "The Weeknd", "Cards", ptype2));
			fanproductRepository.save(new Fanproduct(null, "XO Beauty Behind The Madness", 85.99, "The Weeknd", "Hoodie", ptype1));
					
			
		};
		}

}
