package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.Domain.Author;
import guru.springframework.spring5webapp.Domain.Book;
import guru.springframework.spring5webapp.Domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRespitory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRespitory publisherRespitory;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRespitory publisherRespitory) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRespitory = publisherRespitory;
    }



    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Erik","Evan");
        Book ddd = new Book("Domain Driven Design","256548");

        Publisher publisher=new Publisher();
        publisher.setName("Hasan");
        publisher.setCity("İstanbul");
        publisher.setState("Marmara");

        publisherRespitory.save(publisher);


        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRespitory.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRespitory.save(publisher);


        System.out.println("Number of Books : " + publisher.getBooks().size());

    }
}
