package be.bstorm.models.exo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
        EntityManager em = emf.createEntityManager();
        System.out.println("Coucou");

        Author author = Author.builder()
                .firstname("jean")
                .lastname("loup")
                .build();
        Book book = Book.builder()
                .ISBN("12300")
                .title("toto")
                .literaturePrize("Winner")
                .build();
        BookAuthor bookAuthor = BookAuthor.builder()
                .bookAuthorId(new BookAuthorId())
                .author(author)
                .book(book)
                .year(1991)
                .copyright(12D)
                .build();
        Edition edition = Edition.builder()
                .editionNumber("1")
                .year(1991)
                .nbCopies(100)
                .price(10)
                .book(book)
                .build();

        em.getTransaction().begin();

        em.persist(author);
        em.persist(book);
        em.persist(bookAuthor);
        em.persist(edition);

        em.getTransaction().commit();

    }
}
