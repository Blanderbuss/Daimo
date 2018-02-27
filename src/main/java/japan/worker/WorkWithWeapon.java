package japan.worker;

import japan.data.dao.WeaponDao;
import japan.data.entities.DbWeapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class WorkWithWeapon {

    @Autowired
    private WeaponDao weaponDao;

    public DbWeapon addWeapon(DbWeapon weapon){
        weaponDao.addWeapon(weapon);
        System.out.println("Weapon has been added " + weapon);
        return weapon;
    }
    public DbWeapon getWeaponById(int id){
        return weaponDao.getWeapon(id);
    }
    public void saveWeapon(DbWeapon weapon){
        weaponDao.saveWeapon(weapon);
        System.out.println("Weapon has been saved " + weapon);
    }
}

