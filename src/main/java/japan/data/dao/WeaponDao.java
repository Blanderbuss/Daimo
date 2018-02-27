package japan.data.dao;

import japan.data.entities.DbWeapon;

public interface WeaponDao {
    void addWeapon(DbWeapon weapon);
    DbWeapon getWeapon(int id);
    void saveWeapon(DbWeapon weapon);
}
