package japan.data.dao.impl;

import japan.data.dao.WeaponDao;
import japan.data.entities.DbWeapon;
import japan.data.trans.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class HibernateWeaponDao implements WeaponDao{

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void addWeapon(DbWeapon weapon) {
        currentSession().save(weapon);
    }

    @Override
    public DbWeapon getWeapon(int id) {
        return (DbWeapon) currentSession().get(DbWeapon.class, id);
    }

    @Override
    public void saveWeapon(DbWeapon weapon) {
        final javax.persistence.EntityManagerFactory entityManagerFactory = EntityManagerFactory.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            DbWeapon createdEntity = entityManager.merge(weapon);
            entityManager.getTransaction().commit();
        } catch (Exception ex){
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
        //currentSession().update(weapon);
    }
}
