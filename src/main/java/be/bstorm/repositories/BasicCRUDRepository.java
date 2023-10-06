package be.bstorm.repositories;

import be.bstorm.models.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class BasicCRUDRepository {
    private final EntityManagerFactory emf;

    public BasicCRUDRepository() {
        emf = Persistence.createEntityManagerFactory("DemoJPA");
    }

    public EntityManager openConnection() {
        return emf.createEntityManager();
    }

    public User Add(User user) {

        try (EntityManager em = openConnection()) {

            em.getTransaction().begin();

            em.persist(user);

            em.getTransaction().commit();
//            em.getTransaction().rollback();
//            em.detach(user);
            return user;
        }
    }

    public User getOne(Long id) {
        try (EntityManager em = openConnection()) {
            return em.find(User.class, id);
        }
    }

    public List<User> getAll() {
        try (EntityManager em = openConnection()) {
            TypedQuery<User> query = em.createQuery("select u from User u", User.class);
            return query.getResultList();
        }
    }

    public List<User> getUsersByFirstname(String firstname){
        try(EntityManager em = openConnection()){
            TypedQuery<User> query = em.createQuery("" +
                    "select u " +
                    "from User u " +
                    "where u.firstname like :firstname", User.class);
            query.setParameter("firstname","%" + firstname + "%");
            return query.getResultList();
        }
    }

    public void update(User user) {
        try (EntityManager em = openConnection()) {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }
    }

    public void update(Long id, User user) {
        try (EntityManager em = openConnection()) {
            em.getTransaction().begin();
            User existingUser = em.find(User.class, id);
            if (existingUser == null) {
                throw new RuntimeException("User not found");
            }
            existingUser.setFirstname(user.getFirstname());
            existingUser.setLastname(user.getLastname());
            em.getTransaction().commit();
        }
    }

    public void delete(User user) {
        try (EntityManager em = openConnection()) {
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        }
    }

    public void delete(Long id) {
        try (EntityManager em = openConnection()) {
            em.getTransaction().begin();
            User existingUser = em.find(User.class, id);
            if (existingUser == null) {
                throw new RuntimeException("User not found");
            }
            em.remove(existingUser);
            em.getTransaction().commit();
        }
    }
}
