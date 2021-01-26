package guru.springframework.spring5webapp.bootstrap;

//Spring is going to look for instances of this type and when it finds some, that's going to go ahead and run them.
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepo;
import guru.springframework.spring5webapp.repositories.BookRepo;
import guru.springframework.spring5webapp.repositories.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo pubRepo;


    /*once Spring implements this component that's going to bring it into the Spring context, It will do dependency injection into the constructor for an instance of the author repository and also the book repository.*/
    public BootStrapData(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo pubRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.pubRepo = pubRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started");

        Publisher pub1 = new Publisher();
        pub1.setName("SFG");
        pub1.setCity("St Petersburg");
        pub1.setState("FL");
        pubRepo.save(pub1);


        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design","1234567891032");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(pub1);
        ddd.setPublisher(pub1);
        pub1.getBooks().add(ddd);


        authorRepo.save(eric);
        bookRepo.save(ddd);
        pubRepo.save(pub1);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE DEV without EJB", "1234327659870");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(pub1);
        pub1.getBooks().add(noEJB);

        authorRepo.save(rod);
        bookRepo.save(noEJB);
        pubRepo.save(pub1);


        System.out.println("Publisher count " + pubRepo.count());
        System.out.println("Number of books: "+ bookRepo.count());
        System.out.println("Publisher's number of books: "+ pub1.getBooks().size());


    }
}
