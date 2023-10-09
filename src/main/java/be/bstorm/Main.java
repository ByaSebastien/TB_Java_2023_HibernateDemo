package be.bstorm;

import be.bstorm.models.entities.*;
import be.bstorm.repositories.BasicCRUDRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
        EntityManager em = emf.createEntityManager();

        //#region basic test
//        BasicCRUDRepository userRepo = new BasicCRUDRepository();
//
//        User user1 = new User("Seb","Bya", LocalDate.now(), GenreType.HOMME,new Address("Rue cerisier numero 18",null));
//        User user2 = new User("Alphonse","Brown", LocalDate.now(), GenreType.HOMME,new Address("Rue cerisier numero 18",null));
//        User user4 = new User("Seb","Bya", LocalDate.now(), GenreType.HOMME,new Address("Rue cerisier numero 18",null));

//        user1 = userRepo.Add(user1);
//        user2 = userRepo.Add(user2);
//        user4 = userRepo.Add(user4);

//        User user3 = new User("Hacking","Noob", LocalDate.now(), GenreType.HOMME, new Address("Rue cerisier numero 18",null));
//        userRepo.Add(user3);
//
//        List<User> results = userRepo.getUsersByFirstname("e");
//
//        results.forEach(System.out::println);

//        User resultUser = userRepo.getOne(9L);
//        System.out.println(resultUser);
//
//        List<User> resultUsers = userRepo.getAll();


//        resultUsers.forEach(System.out::println);

//        for(User u : resultUsers){
//            System.out.println(u);
//        }
//
//        List<String> result = resultUsers.stream()
//                .map(User::getFirstname)
//                .filter(firstname -> firstname.startsWith("S"))
//                        .toList();
//
//        result.forEach(System.out::println);
//
//        System.out.println("Finito!");
        //#endregion

        Mayor mayor = Mayor.builder()
                .name("Henry Christophe")
                .build();
        Municipality municipality = Municipality.builder()
                .name("Fexhe le Haut Clocher")
                .build();
        Province province = Province.builder()
                .name("Liège")
                .municipalities(new ArrayList<>())
                .build();



        municipality.setMayor(mayor);
        municipality.setProvince(province);

        em.getTransaction().begin();

        em.persist(municipality);

        em.getTransaction().commit();

        Province p = em.find(Province.class,1L);

        System.out.println("Coucou");


    }
}