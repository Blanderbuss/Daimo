package japan.worker;

import com.googlecode.ehcache.annotations.Cacheable;
import japan.Weapon;
import japan.data.dao.WeaponDao;
import japan.data.entities.DbWeapon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;


public class WorkWithWeapon {

    @Autowired
    private WeaponDao weaponDao;

    @Autowired
    TransactionTemplate transactionTemplate;

    @Cacheable(cacheName="weaponsCache")
    public DbWeapon addWeapon(DbWeapon weapon){
        transactionTemplate.execute(new TransactionCallback<Void>() {
            public Void doInTransaction(TransactionStatus txStatus) {
                try {
                    weaponDao.addWeapon(weapon);
                    System.out.println("Weapon has been added " + weapon);
                } catch (RuntimeException e) {
                    txStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
        return weapon;
    }

    @Cacheable(cacheName="weaponsCache")
    public DbWeapon getWeaponById(int id){
        return transactionTemplate.execute(new TransactionCallback<DbWeapon>() {
            public DbWeapon doInTransaction(TransactionStatus txStatus) {
                try {
                    System.out.println("Entered weapon worker");
                    return weaponDao.getWeapon(id);
                } catch (RuntimeException e) {
                    txStatus.setRollbackOnly();
                    throw e;
                }
            }
        });
    }

    public void saveWeapon(DbWeapon weapon){
        transactionTemplate.execute(new TransactionCallback<Void>() {
            public Void doInTransaction(TransactionStatus txStatus) {
                try {
                    weaponDao.saveWeapon(weapon);
                    System.out.println("Weapon has been saved " + weapon);
                } catch (RuntimeException e) {
                    txStatus.setRollbackOnly();
                    throw e;
                }
                return null;
            }
        });
    }
}

