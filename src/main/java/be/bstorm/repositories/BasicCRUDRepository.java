package be.bstorm.repositories;

import be.bstorm.models.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class BasicCRUDRepository {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoJPA");
    private final EntityManager em;

    public BasicCRUDRepository(){
        em = emf.createEntityManager();
    }

    public User Add(User user){
        em.getTransaction().begin();

        em.persist(user);

        em.getTransaction().commit();

        em.detach(user);

        return user;
    }

    public User getOne(Long id){
        return em.find(User.class,id);
    }

    public List<User> getAll(){
        TypedQuery<User> query = em.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    public void update(User user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public void update(Long id, User user){
        em.getTransaction().begin();
        User existingUser = em.find(User.class,id);
        if(existingUser == null){
            throw new RuntimeException("User not found");
        }
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        em.getTransaction().commit();
    }

    public void delete(User user){
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();
    }

    public void delete(Long id){
        em.getTransaction().begin();
        User existingUser = em.find(User.class,id);
        if(existingUser == null){
            throw new RuntimeException("User not found");
        }
        em.remove(existingUser);
        em.getTransaction().commit();
    }
}
