package japan.data.trans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.Persistence;

@Component
public class EntityManagerFactory {
    private static volatile javax.persistence.EntityManagerFactory factory;
    private static final Object monitor = new Object();
    private static String persistentUnitName;

    private EntityManagerFactory() {}
    public static javax.persistence.EntityManagerFactory getEntityManagerFactory() {
        javax.persistence.EntityManagerFactory localFactory = factory;
        if (localFactory == null) {
            synchronized (monitor) {
                localFactory = factory;
                if (localFactory == null) {
                    localFactory = factory = Persistence.createEntityManagerFactory(persistentUnitName);
                }
            }
        }
        return localFactory;
    }

    public static void setFactory(final javax.persistence.EntityManagerFactory factory) {
        EntityManagerFactory.factory = factory;
    }

    @Value("tUnit")
    public void setPersistentUnitName(String persistentUnitName){
        EntityManagerFactory.persistentUnitName = persistentUnitName;
    }

}

