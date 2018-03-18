package japan.data.dao.impl;

import japan.data.entities.Ceremony;
import japan.data.dao.CeremoniesDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CeremoniesDaoJPAImpl implements CeremoniesDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Ceremony addCeremony(Ceremony ceremony) {
        em.persist(ceremony);
        return ceremony;
    }

    @Override
    public Ceremony getCeremony(int id) {
        return em.find(Ceremony.class,id);
    }

    @Override
    public void saveCeremony(Ceremony ceremony) {
        em.merge(ceremony);
    }

    @Override
    public List<Ceremony> getAllCeremonies() {
        Query query = em.createQuery("SELECT e FROM Ceremony e");
        return (List<Ceremony>) query.getResultList();
    }
}
