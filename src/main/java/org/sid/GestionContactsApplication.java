package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionContactsApplication implements CommandLineRunner{
	@Autowired
	private ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(GestionContactsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contact("Hassani","Mohammed", df.parse("12/01/1988"), "hassan@gmail.com",0661345432,"hassan.jpg"));
		contactRepository.save(new Contact("Ibrahimi","Khalid", df.parse("12/01/1988"), "hassan@gmail.com",0661345432,"hassan.jpg"));
		contactRepository.save(new Contact("Kaoutar","Hicham", df.parse("12/01/1988"), "hassan@gmail.com",0661345432,"hassan.jpg"));
		
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
	}
}
