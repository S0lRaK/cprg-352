package ca.sait.itsd;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Carlos J. Garcia Carmona <carlos.garciacarmona@edu.sait.ca>
 */
public class DBoperations {

    public String getUsernames() {
        String result = "";

        EntityManager entityManager = DButil.getEntityManagerFactory().createEntityManager();
        Query usernames = entityManager.createNamedQuery("Users.findAll", Users.class);
        List<Users> usernamesList;

        try {
            usernamesList = usernames.getResultList();

            for (Users user : usernamesList) {
                result += user.getUsername() + ",";
            }
        } finally {
            entityManager.close();
        }

        return result;
    }

    public boolean addUsername(String username) {
        boolean result = false;

        EntityManager entityManager = DButil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            
            entityManager.persist(new Users(0, username));
            
            entityTransaction.commit();

            result = true;
        } catch (Exception exception) {
            entityTransaction.rollback();
            exception.printStackTrace();
        }

        return result;
    }
    
    public boolean deleteUsername(String username) {
        boolean result = false;

        EntityManager entityManager = DButil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            
            Users user = (Users) entityManager.createNamedQuery("Users.findByUsername")
                    .setParameter("username", username)
                    .getSingleResult();
            
            entityManager.remove(user);
            
            entityTransaction.commit();

            result = true;
        } catch (Exception exception) {
            entityTransaction.rollback();
            exception.printStackTrace();
        }

        return result;
    }
    
    public boolean updateUsername(String username, String newUsername) {
        boolean result = false;

        EntityManager entityManager = DButil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            
            Users user = (Users) entityManager.createNamedQuery("Users.findByUsername")
                    .setParameter("username", username)
                    .getSingleResult();
            
            user.setUsername(newUsername);
            
            entityTransaction.commit();

            result = true;
        } catch (Exception exception) {
            entityTransaction.rollback();
            exception.printStackTrace();
        }

        return result;
    }
}
