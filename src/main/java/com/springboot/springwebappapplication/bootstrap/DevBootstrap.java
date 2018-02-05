package com.springboot.springwebappapplication.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springboot.springwebappapplication.model.Author;
import com.springboot.springwebappapplication.model.Book;
import com.springboot.springwebappapplication.repositories.AuthorRepository;
import com.springboot.springwebappapplication.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}
	
	private void initData() {
		
		//Eric
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		//Rod
		Author rod = new Author("Rod", "Jonson");
		Book noEJB = new Book("J2EE Development without EJB", "1234", "Work");
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
