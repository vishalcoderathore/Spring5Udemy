package com.springboot.springwebappapplication.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springboot.springwebappapplication.model.Author;
import com.springboot.springwebappapplication.model.Book;
import com.springboot.springwebappapplication.model.Publisher;
import com.springboot.springwebappapplication.repositories.AuthorRepository;
import com.springboot.springwebappapplication.repositories.BookRepository;
import com.springboot.springwebappapplication.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository; 
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	private void initData() {
		
		//Publisher
		Publisher publisher = new Publisher();
		publisher.setFirstName("Mike");
		publisher.setLastName("Jordan");
		publisher.setAddressLine1("1560 Oak Street");
		publisher.setAddressLine2("50th Ave");
		publisher.setCity("Central City");
		publisher.setProvince("Minnesota");
		publisher.setCountry("USA");
		publisher.setZipCode(00000000);
		
		publisherRepository.save(publisher);
		
		//Eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", publisher);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		//Rod
		Author rod = new Author("Rod", "Jonson");
		Book noEJB = new Book("J2EE Development without EJB", "1234", publisher);
		rod.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		initData();
	}
}
