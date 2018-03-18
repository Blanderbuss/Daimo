package japan.worker;

import com.googlecode.ehcache.annotations.Cacheable;
import japan.data.dao.WeaponDao;
import japan.data.entities.DbWeapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;



@Transactional
public class WorkWithWeapon {

    @Autowired
    private WeaponDao weaponDao;

    @Cacheable(cacheName="weaponsCache")
    public DbWeapon addWeapon(DbWeapon weapon){
        weaponDao.addWeapon(weapon);
        System.out.println("Weapon has been added " + weapon);
        return weapon;
    }

    @Cacheable(cacheName="weaponsCache")
    public DbWeapon getWeaponById(int id){
        System.out.println("Enterd weapon worker");
        return weaponDao.getWeapon(id);
    }

    public void saveWeapon(DbWeapon weapon){
        weaponDao.saveWeapon(weapon);
        System.out.println("Weapon has been saved " + weapon);
    }
}

