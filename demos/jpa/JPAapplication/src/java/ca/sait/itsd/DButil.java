package ca.sait.itsd;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Carlos J. Garcia Carmona <carlos.garciacarmona@edu.sait.ca>
 */
public class DButil {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = 
            Persistence.createEntityManagerFactory("JPAapplicationPU");
    
    public static EntityManagerFactory getEntityManagerFactory() {
        return ENTITY_MANAGER_FACTORY;
    }
}
