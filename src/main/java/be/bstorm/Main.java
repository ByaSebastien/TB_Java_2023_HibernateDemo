package be.bstorm;

import be.bstorm.models.entities.Address;
import be.bstorm.models.entities.GenreType;
import be.bstorm.models.entities.User;
import be.bstorm.repositories.BasicCRUDRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BasicCRUDRepository userRepo = new BasicCRUDRepository();

        User user1 = new User("Seb","Bya", LocalDate.now(), GenreType.HOMME,new Address("Rue cerisier numero 18",null));
        User user2 = new User("Alphonse","Brown", LocalDate.now(), GenreType.HOMME,new Address("Rue cerisier numero 18",null));

        user1 = userRepo.Add(user1);
        user2 = userRepo.Add(user2);

        User user3 = new User(1L,"Hacking","Noob", LocalDate.now(), GenreType.HOMME, new Address("Rue cerisier numero 18",null));
        userRepo.update(user3);

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
    }
}