package com.oxellerator.spring5webapp.bootstrap;

import com.oxellerator.spring5webapp.model.Author;
import com.oxellerator.spring5webapp.model.Book;
import com.oxellerator.spring5webapp.model.Publisher;
import com.oxellerator.spring5webapp.repositories.AuthorRepository;
import com.oxellerator.spring5webapp.repositories.BookRepository;
import com.oxellerator.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author <a:href="mailto:ol.sakura@gmail.com">Olexiy Sokurenko</a>
 **/
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){
        Publisher harper = new Publisher("Harper Collins", "Magnoliadrive 5");
        Publisher worx = new Publisher("Worx", "Musterstreat 1");
        publisherRepository.save(harper);
        publisherRepository.save(worx);

        //Erik
        Author erik = new Author("Erik", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        erik.getBooks().add(ddd);
        ddd.getAuthors().add(erik);

        authorRepository.save(erik);
        bookRepository.save(ddd);
        //Rod
        Author rod= new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
