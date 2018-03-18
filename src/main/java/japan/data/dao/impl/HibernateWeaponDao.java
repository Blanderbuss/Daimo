package japan.data.dao.impl;

import japan.data.dao.WeaponDao;
import japan.data.entities.DbWeapon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        currentSession().update(weapon);
    }
}
